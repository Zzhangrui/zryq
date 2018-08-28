package com.zryq.cms.admin.service;

import com.google.common.base.Strings;
import com.zryq.cms.admin.dao.FlyUserMapper;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.jstree.JsonResultEnum;
import com.zryq.cms.common.utils.CaptchaUtil;
import com.zryq.cms.common.utils.MD5;
import com.zryq.cms.common.utils.SessionPerson;
import com.zryq.cms.common.utils.SessionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FlyUserService extends BaseService<FlyUserMapper, FlyUser> {

    @Autowired
    private FlyUserMapper flyUserMapper;

    public JsonResult login(String email, String password,String verifyCode) {
        if (Strings.isNullOrEmpty(email) || Strings.isNullOrEmpty(password)) {
            return new JsonResult(JsonResultEnum.LOGIN_EMPTY, false);
        }
        String sessionVerifyCode = (String)SessionUtil.getValue(CaptchaUtil.LOGIN_SIMPLE_CAPTCHA);
        if(Strings.isNullOrEmpty(verifyCode)||Strings.isNullOrEmpty(sessionVerifyCode)||!verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            return new JsonResult(JsonResultEnum.VERIFY_CODE_ERROR,false);
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

    public JsonResult register(FlyUser flyUser,String verifyCode) {
        String sessionVerifyCode = (String)SessionUtil.getValue(CaptchaUtil.REGISTER_SIMPLE_CAPTCHA);
        if(Strings.isNullOrEmpty(verifyCode)||Strings.isNullOrEmpty(sessionVerifyCode)||!verifyCode.equalsIgnoreCase(sessionVerifyCode)){
            return new JsonResult(JsonResultEnum.VERIFY_CODE_ERROR,false);
        }
        JsonResult jsonResult = validate(flyUser);
        if (!jsonResult.isSuccess()) {
            return jsonResult;
        }
        flyUserMapper.insertSelective(flyUser);
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
}
