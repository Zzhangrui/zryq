package com.zryq.cms.admin.service;

import com.google.common.base.Strings;
import com.zryq.cms.admin.dao.FlyAttentionMapper;
import com.zryq.cms.admin.dao.FlyUserMapper;
import com.zryq.cms.admin.entity.FlyAttention;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.jstree.JsonResultEnum;
import com.zryq.cms.common.enums.FlyUserStatus;
import com.zryq.cms.common.redis.JedisClient;
import com.zryq.cms.common.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FlyUserService extends BaseService<FlyUserMapper, FlyUser> {

    private static final String DEFAULT_HEAD_IMG_PATH = "/assets/blog/images/default.jpg";

    private static final String SALT_PREFIX = "SALT_";

    private static final String EMAIL_UUID_PREFIX = "EMAIL_";

    private static final String FORGET_MAIL_SUBJECT = "【重置密码】";
    @Autowired
    private FlyUserMapper flyUserMapper;

    @Autowired
    private FlyAttentionMapper flyAttentionMapper;

    @Autowired
    private FileOperateService fileOperateService;

    @Autowired
    private JedisClient jedisClient;


    public JsonResult login(String email, String password, String verifyCode) {
        if (Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)) {
            return new JsonResult(JsonResultEnum.LOGIN_EMPTY, false);
        }
        String sessionVerifyCode =
                (String) SessionUtil.getValue(CaptchaUtil.VerifyCodeType.LOGIN.getCodeTypeValue());
        if (Strings.isNullOrEmpty(verifyCode) || Strings.isNullOrEmpty(sessionVerifyCode)
                || !verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
            return new JsonResult(JsonResultEnum.VERIFY_CODE_ERROR, false);
        }
        FlyUser flyUser = new FlyUser();
        flyUser.setEmail(email);
        List<FlyUser> flyUsers = flyUserMapper.select(flyUser);
        if (CollectionUtils.isEmpty(flyUsers)) {
            return new JsonResult(JsonResultEnum.USER_NOT_EXIST, false);
        } else {
            flyUser = flyUsers.get(0);
            if (MD5.MD5Encode(password).equals(flyUser.getPassword())) {
                flyUser.setLastLoginTime(new Date());
                flyUserMapper.updateByPrimaryKey(flyUser);
                SessionPerson.saveFlyUser(flyUser);
                return JsonResult.SUCCESS;
            } else {
                return new JsonResult(JsonResultEnum.PASSWORD_ERROR, false);
            }
        }
    }

    public JsonResult register(FlyUser flyUser, String verifyCode) {
        String sessionVerifyCode =
                (String) SessionUtil.getValue(CaptchaUtil.VerifyCodeType.REGISTER.getCodeTypeValue());
        if (Strings.isNullOrEmpty(verifyCode) || Strings.isNullOrEmpty(sessionVerifyCode)
                || !verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
            return new JsonResult(JsonResultEnum.VERIFY_CODE_ERROR, false);
        }
        JsonResult jsonResult = validate(flyUser);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        String email = flyUser.getEmail();
        //String nickName = flyUser.getNickName();
        FlyUser checkFlyUser = new FlyUser();
        checkFlyUser.setEmail(email);
        //checkFlyUser.setNickName(nickName);
        List<FlyUser> flyUsers = flyUserMapper.select(checkFlyUser);
        if (CollectionUtils.isNotEmpty(flyUsers)) {
            return new JsonResult(JsonResultEnum.USERNAME_REPEAT, false);
        }
        flyUser.setPassword(MD5.MD5Encode(flyUser.getPassword()));
        flyUser.setLastLoginTime(new Date());
        flyUser.setUpdateTime(new Date());
        flyUser.setCreateTime(new Date());
        flyUser.setStatus(FlyUserStatus.NORMAL.getCode());
        flyUser.setImgPath(DEFAULT_HEAD_IMG_PATH);
        flyUser.setLevel("5");
        flyUser.setUuid(UUID.randomUUID().toString());
        flyUserMapper.insertSelective(flyUser);
        SessionPerson.saveFlyUser(flyUser);
        return JsonResult.SUCCESS;
    }

    public JsonResult forget(String email, String verifyCode) {
        String sessionVerifyCode =
                (String) SessionUtil.getValue(CaptchaUtil.VerifyCodeType.FORGET.getCodeTypeValue());
        if (Strings.isNullOrEmpty(verifyCode) || Strings.isNullOrEmpty(sessionVerifyCode)
                || !verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
            return new JsonResult(JsonResultEnum.VERIFY_CODE_ERROR, false);
        }

        email = email.toLowerCase();
        FlyUser flyUser = new FlyUser();
        flyUser.setEmail(email);
        List<FlyUser> flyUsers = flyUserMapper.select(flyUser);
        if (CollectionUtils.isEmpty(flyUsers)) {
            return JsonResult.ERROR_PARAM;
        }
        flyUser = flyUsers.get(0);
        try {
            //初始化盐
            byte[] salt = PBECoderUtil.initSalt();
            //加密UUID
            String encryptData =
                    PBECoderUtil.encrypt(flyUser.getUuid().getBytes(), PBECoderUtil.PASSWORD, salt).toString();

            //存redis 30min有效时间
            jedisClient.set(SALT_PREFIX + email, salt.toString(), 30 * 60);
            jedisClient.set(EMAIL_UUID_PREFIX + email, flyUser.getUuid(), 30 * 60);
            sendForgetEmail(email, encryptData);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.FAIL;
        }

        return JsonResult.SUCCESS;
    }

    public boolean checkLink(String email, String data) {
        email = email.toLowerCase();
        String saltStr = jedisClient.get(SALT_PREFIX + email);
        if (Strings.isNullOrEmpty(saltStr)) {
            return false;
        }
        String uuid = jedisClient.get(EMAIL_UUID_PREFIX + email);
        if (Strings.isNullOrEmpty(uuid)) {
            return false;
        }
        try {
            String u =
                    PBECoderUtil.decrypt(data.getBytes(), PBECoderUtil.PASSWORD, saltStr.getBytes()).toString();
            if (uuid.equals(u)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public JsonResult reset(FlyUser flyUser, String data) {
        if (null == flyUser || Strings.isNullOrEmpty(flyUser.getEmail())
                || Strings.isNullOrEmpty(flyUser.getPassword())
                || Strings.isNullOrEmpty(flyUser.getRePassword())
                || !flyUser.getPassword().equals(flyUser.getRePassword())
                || Strings.isNullOrEmpty(data)) {
            return JsonResult.ERROR_PARAM;
        }
        if (!checkLink(flyUser.getEmail(), data)) {
            return JsonResult.ERROR_PARAM;
        }
        String email = flyUser.getEmail();
        String password = flyUser.getPassword();
        flyUser = new FlyUser();
        flyUser.setEmail(email);
        flyUser.setPassword(MD5.MD5Encode(password));
        flyUser.setUpdateTime(new Date());
        Example example = new Example(FlyUser.class);
        example.createCriteria().andEqualTo("email", email);
        flyUserMapper.updateByExampleSelective(flyUser, example);
        //更新成功
        return JsonResult.SUCCESS;
    }

    public JsonResult validate(FlyUser flyUser) {
        if (null == flyUser) {
            return JsonResult.ERROR_PARAM;
        }
        if (Strings.isNullOrEmpty(flyUser.getEmail())
                || Strings.isNullOrEmpty(flyUser.getPassword())
                || Strings.isNullOrEmpty(flyUser.getNickName())
                || Strings.isNullOrEmpty(flyUser.getRePassword())) {
            return JsonResult.ERROR_PARAM;
        }

        if (!flyUser.getPassword().equals(flyUser.getRePassword())) {
            return new JsonResult(JsonResultEnum.PASSWORD_ERROR, false);
        }
        return JsonResult.SUCCESS;
    }

    public FileAttr modifyUpload(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String dirPath) {
        FileAttr fileAttr = fileOperateService.upload(file, request, response, dirPath);
        if ("0".equals(fileAttr.getCode())) {
            Integer id = SessionPerson.currentFlyUser().getId();
            FlyUser flyUser = flyUserMapper.selectByPrimaryKey(id);
            flyUser.setImgPath(fileAttr.getUrl());
            flyUser.setId(id);
            flyUser.setUpdateTime(new Date());
            SessionPerson.saveFlyUser(flyUser);
            flyUserMapper.updateByPrimaryKeySelective(flyUser);
        }
        return fileAttr;
    }

    public JsonResult modifyBaseInfo(FlyUser flyUser) {
        if (Strings.isNullOrEmpty(flyUser.getNickName())) {
            return JsonResult.ERROR_PARAM;
        }
        FlyUser user = SessionPerson.currentFlyUser();
        user = flyUserMapper.selectByPrimaryKey(user);
        user.setNickName(flyUser.getNickName());
        user.setAddress(flyUser.getAddress());
        user.setSign(flyUser.getSign());
        user.setSex(flyUser.getSex());
        flyUserMapper.updateByPrimaryKeySelective(user);
        SessionPerson.saveFlyUser(user);
        return JsonResult.SUCCESS;
    }

    public JsonResult modifyPassword(String localPassword, String newPassword, String reNewPassword) {
        if (Strings.isNullOrEmpty(localPassword) || Strings.isNullOrEmpty(newPassword)
                || Strings.isNullOrEmpty(reNewPassword)) {
            return JsonResult.ERROR_PARAM;
        }
        FlyUser flyUser = SessionPerson.currentFlyUser();
        if (!MD5.MD5Encode(localPassword).equals(flyUser.getPassword())) {
            return new JsonResult(JsonResultEnum.OLD_PASSWORD_ERROR, false);
        }
        if (newPassword.equals(reNewPassword)) {
            return new JsonResult(JsonResultEnum.REPASSOWRD_WRONG, false);
        }
        FlyUser user = flyUserMapper.selectByPrimaryKey(flyUser.getId());
        user.setId(flyUser.getId());
        user.setUpdateTime(new Date());
        user.setPassword(MD5.MD5Encode(newPassword));
        flyUserMapper.updateByPrimaryKeySelective(user);
        SessionPerson.saveFlyUser(user);
        return JsonResult.SUCCESS;
    }

    public FlyUser selectByUuid(String uuid) {
        if (Strings.isNullOrEmpty(uuid)) {
            return null;
        }
        FlyUser flyUser = new FlyUser();
        flyUser.setUuid(uuid);
        flyUser = flyUserMapper.selectOne(flyUser);
        return flyUser;
    }


    public JsonResult sendForgetEmail(String email, String data) {
        HttpServletRequest request = Servlets.getRequest();
        String host = request.getRemoteHost();
        String path = request.getContextPath();
        String resetPassHref = host + path + "/fly/reset?email=" + email + "&data=" + data;
        String emailContent =
                "请勿回复本邮件.点击下面的链接重设密码<br/><a href=" + resetPassHref + " target='_BLANK'>"
                        + resetPassHref + "</a><br/>tips:本邮件超过30分钟链接将会失效，30分钟之内本链接可以重复使用。";
        try {
            MailService.sendMail(FORGET_MAIL_SUBJECT, email, emailContent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return JsonResult.SUCCESS;
    }

    public JsonResult attention(Integer type, Integer toUserId) {

        if ((type != 1 && type != 2) || null == toUserId) {
            return JsonResult.ERROR_PARAM;
        }
        FlyUser flyUser = SessionPerson.currentFlyUser();
        FlyAttention flyAttention = new FlyAttention();
        flyAttention.setToUserId(toUserId);
        flyAttention.setFromUserId(flyUser.getId());
        //新增
        if (1 == type) {
            flyAttentionMapper.insert(flyAttention);
        } else {
            flyAttentionMapper.delete(flyAttention);
        }
        return JsonResult.SUCCESS;
    }


}
