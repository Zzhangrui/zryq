package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.FlyPostMapper;
import com.zryq.cms.admin.dao.FlyUserMapper;
import com.zryq.cms.admin.entity.FlyPost;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.enums.FlyPostConstant;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/30
 * Time: 17:43
 * To change this template use File | Settings | File Templates.
 */
@Service
public class FlyPostService {

    @Autowired
    private FlyPostMapper flyPostMapper;

    @Autowired
    private FlyUserMapper flyUserMapper;

    public JsonResult edit(FlyPost flyPost){
        flyPost.setCategoryName(FlyPostConstant.PostCategory.getText(flyPost.getCategoryId()));
        if(null == flyPost.getId()){
            FlyUser flyUser = SessionPerson.currentFlyUser();
            flyPost.setCreateTime(new Date());
            flyPost.setUpdateTime(new Date());
            flyPost.setCreateUserId(flyUser.getId());
            flyPost.setCreateUserName(flyUser.getNickName());
            flyPost.setExcellent(FlyPostConstant.PostRecommend.NotRecommended.getValue());
            flyPost.setTop(FlyPostConstant.PostTop.NotPutTop.getValue());
            flyPost.setEnd(FlyPostConstant.PostEnd.NOT_END.getValue());
            flyPostMapper.insert(flyPost);
        }else{
            flyPost.setUpdateTime(new Date());
            flyPostMapper.updateByPrimaryKeySelective(flyPost);
        }
        return JsonResult.SUCCESS;
    }



    public JsonResult delete(Integer id){

        FlyPost flyPost = new FlyPost();
        flyPost.setId(id);
        FlyUser flyUser = SessionPerson.currentFlyUser();
        flyPost.setCreateUserId(flyUser.getId()); //防止误删
        flyPostMapper.deleteByPrimaryKey(flyPost);
        return JsonResult.SUCCESS;
    }

    public PageInfo data(Integer pageNum,Integer pageSize,FlyPost flyPost){
        if(null == pageNum){
            pageNum = 0;
        }
        if(null == pageSize){
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<FlyPost> flyPostList = flyPostMapper.select(flyPost);
        flyPostList.forEach(flyPost1 -> {
            Integer userId = flyPost1.getCreateUserId();
            FlyUser flyUser = new FlyUser();
            flyUser.setId(userId);
            flyUser = flyUserMapper.selectByPrimaryKey(flyUser);
            flyPost1.setCreateUserImg(flyUser.getImgPath());
        });
        PageInfo pageInfo = new PageInfo(flyPostList);
        return pageInfo;
    }

    public FlyPost getEdit(Integer id){
        FlyUser flyUser = SessionPerson.currentFlyUser();
        FlyPost flyPost = new FlyPost();
        flyPost.setId(id);
        flyPost.setCreateUserId(flyUser.getId());
        return flyPostMapper.selectOne(flyPost);
    }

    public FlyPost detail(Integer id){
        if(null == id ){
            return null;
        }
        FlyPost flyPost = new FlyPost();
        if(flyPost == null){
            return null;
        }
        flyPost.setId(id);
        flyPost = flyPostMapper.selectByPrimaryKey(flyPost);
        FlyUser flyUser = new FlyUser();
        flyUser.setId(flyPost.getCreateUserId());
        flyUser = flyUserMapper.selectByPrimaryKey(flyUser);
        flyPost.setCreateUserImg(flyUser.getImgPath());
        return flyPost;
    }
}
