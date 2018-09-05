package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.zryq.cms.admin.dao.FlyMessageMapper;
import com.zryq.cms.admin.entity.FlyMessage;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.redis.JedisClient;
import com.zryq.cms.common.utils.SessionPerson;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/9/4
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FlyMessageService extends BaseService<FlyMessageMapper, FlyMessage> {

    private static final Integer YES = 1;
    private static final Integer NO = 0;

    @Autowired
    private FlyMessageMapper flyMessageMapper;

    @Autowired
    private JedisClient jedisClient;

    public JsonResult add(String content, Integer receiveId, Integer parentId) {
        if (Strings.isNullOrEmpty(content) || null == receiveId) {
            return JsonResult.ERROR_PARAM;
        }
        FlyMessage flyMessage = new FlyMessage();
        flyMessage.setContent(content);
        flyMessage.setReceiveUserId(receiveId);
        if (null != parentId) {
            flyMessage.setParentId(parentId);
        }
        FlyUser flyUser = SessionPerson.currentFlyUser();
        flyMessage.setSendUserId(flyUser.getId());
        flyMessage.setIsRead(NO);
        flyMessage.setCreateTime(new Date());
        flyMessage.setUpdateTime(new Date());
        flyMessageMapper.insert(flyMessage);
        return JsonResult.SUCCESS;
    }

    public JsonResult reply(String content, Integer parentId) {
        FlyMessage flyMessage = new FlyMessage();
        flyMessage.setId(parentId);
        flyMessage = flyMessageMapper.selectByPrimaryKey(flyMessage);
        FlyMessage replyMessage = new FlyMessage();
        FlyUser flyUser = SessionPerson.currentFlyUser();
        replyMessage.setSendUserId(flyUser.getId());
        replyMessage.setReceiveUserId(flyMessage.getSendUserId());
        replyMessage.setParentId(parentId);
        replyMessage.setContent(content);
        replyMessage.setIsRead(NO);
        replyMessage.setCreateTime(new Date());
        replyMessage.setUpdateTime(new Date());
        flyMessageMapper.insert(replyMessage);
        return JsonResult.ERROR_PARAM;
    }

    public JsonResult delete(Integer id) {
        if (null == id) {
            return JsonResult.ERROR_PARAM;
        }
        List<Integer> idList = Lists.newArrayList();
        getReplyId(id, idList);
        Example example = new Example(FlyMessage.class);
        Example.Criteria criteria = example.or();
        criteria.andIn("id", idList);
        flyMessageMapper.deleteByExample(example);
        return JsonResult.SUCCESS;
    }

    /**
     * 递归获取回复id
     *
     * @param parentId
     * @param idList
     * @return
     */
    public List<Integer> getReplyId(Integer parentId, List<Integer> idList) {
        FlyMessage flyMessage = new FlyMessage();
        flyMessage.setParentId(parentId);
        List<FlyMessage> flyMessageList = flyMessageMapper.select(flyMessage);
        if (CollectionUtils.isNotEmpty(flyMessageList)) { //还有子孙节点
            flyMessageList.forEach(flyMessage1 -> {
                idList.add(flyMessage1.getId());
                this.getReplyId(parentId, idList);
            });
        } else {
            idList.add(parentId);
        }
        return idList;
    }


    /**
     * 根据id ，获取所有回复
     *
     * @param parentId
     * @param replyList
     * @return
     */
    public void getReplyList(FlyMessage flyMessage) {
        List<FlyMessage> flyMessageList =
                flyMessageMapper.getMessage(null, flyMessage.getId(), null);
        if (CollectionUtils.isNotEmpty(flyMessageList)) {
            flyMessageList.forEach(flyMessage1 -> {
                this.getReplyList(flyMessage1);
                flyMessage.setReplyList(flyMessageList);
            });
        }
        return;
    }



    public PageInfo<FlyMessage> getReceiveMessage(Integer pageNum, Integer pageSize) {
        if (null == pageNum) {
            pageNum = 0;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        FlyUser flyUser = SessionPerson.currentFlyUser();
        PageHelper.startPage(pageNum, pageSize);
        List<FlyMessage> flyMessageList = flyMessageMapper.getMessage(flyUser.getId(), null, null);
        if (CollectionUtils.isNotEmpty(flyMessageList)) {
            flyMessageList.forEach(flyMessage -> {
                Integer parentId = flyMessage.getId();
                getReplyList(flyMessage);

            });
        }
        PageInfo pageInfo = new PageInfo(flyMessageList);
        return pageInfo;
    }

    public JsonResult getUnReadMessageCount() {
        FlyUser flyUser = SessionPerson.currentFlyUser();
        if (null == flyUser) {
            return null;
        }
        FlyMessage flyMessage = new FlyMessage();
        flyMessage.setIsRead(NO);
        flyMessage.setReceiveUserId(flyUser.getId());
        Integer count = flyMessageMapper.selectCount(flyMessage);
        if (null == count) {
            count = 0;
        }
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        jsonResult.setData(count);
        return jsonResult;
    }
}
