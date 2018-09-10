package com.zryq.cms.front.controller;

import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.FlyPost;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.admin.service.*;
import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.Servlets;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 16:33
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("fly/user")
public class FlyUserCenterController {

    @Autowired
    private FlyUserService flyUserService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private FlyPostService flyPostService;

    @Autowired
    private FlyMessageService flyMessageService;

    @GetMapping("index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/fly/center_index");
        return modelAndView;
    }

    @GetMapping("home/{uuid}")
    public ModelAndView home(@PathVariable String uuid){
        ModelAndView modelAndView = new ModelAndView("/fly/center_home");
        FlyUser flyUser = flyUserService.selectByUuid(uuid);
        if(null == flyUser){
           modelAndView.setViewName("error");
           return modelAndView;
        }
        modelAndView.addObject("articleList",articleService.getSelfArticle(0,10,flyUser.getId()).getList());
        FlyPost flyPost = new FlyPost();
        flyPost.setCreateUserId(flyUser.getId());
        modelAndView.addObject("postList",flyPostService.data(0,10,flyPost).getList());
        modelAndView.addObject("friendUser", flyUserService.selectByUuid(uuid));
        return modelAndView;
    }

    @PostMapping("selfArticle")
    @ResponseBody
    public PageInfo getSelfArticle(Integer pageNum,Integer pageSize){
        FlyUser flyUser = SessionPerson.currentFlyUser();
        Integer id = flyUser.getId();
        return articleService.getSelfArticle(pageNum,pageSize,id);
    }

    @PostMapping("selfLike")
    @ResponseBody
    public PageInfo getSelfLikeArticle(Integer pageNum,Integer pageSize){
        FlyUser flyUser = SessionPerson.currentFlyUser();
        Integer id = flyUser.getId();
        return articleService.getSelfLikeArticle(pageNum,pageSize,id);
    }

    @GetMapping("edit")
    public ModelAndView edit(Integer id){

        ModelAndView modelAndView = new ModelAndView("/fly/center_article_edit");
        if(null!=id){
            modelAndView.addObject("article",articleService.selectById(id));
        }
        modelAndView.addObject("columnList",columnService.selectAll());
        return modelAndView;
    }

    @PostMapping("edit")
    @ResponseBody
    public JsonResult edit(Article article){
        articleService.edit(article);
        return JsonResult.SUCCESS;
    }

    @GetMapping("set")
    public ModelAndView set(){
        ModelAndView modelAndView = new ModelAndView("/fly/center_user_set");
        modelAndView.addObject("selfUser", SessionPerson.currentFlyUser());
        return modelAndView;
    }

    @PostMapping("baseInfo")
    @ResponseBody
    public JsonResult modifyBaseInfo(FlyUser flyUser){
        return flyUserService.modifyBaseInfo(flyUser);
    }

    @PostMapping("img")
    @ResponseBody
    public FileAttr modifyImg(MultipartFile file, HttpServletRequest request, HttpServletResponse response, String dirPath){
        return flyUserService.modifyUpload(file,request,response,dirPath);
    }

    @PostMapping("password")
    @ResponseBody
    public JsonResult modifyPassword(String localPassword,String newPassword,String reNewPassword){
        return flyUserService.modifyPassword(localPassword,newPassword,reNewPassword);
    }

    @GetMapping("message")
    public ModelAndView message(){
        ModelAndView modelAndView = new ModelAndView("/fly/center_message");
        return modelAndView;
    }

    @PostMapping("getReceiveMessage")
    @ResponseBody
    public PageInfo message(Integer pageNum,Integer pageSize){
        FlyUser flyUser = SessionPerson.currentFlyUser();
        return flyMessageService.getMessage(flyUser.getId(),null,pageNum,pageSize);
    }

    @PostMapping("getSendMessage")
    @ResponseBody
    public PageInfo getSendMessage(Integer pageNum,Integer pageSize){
        FlyUser flyUser = SessionPerson.currentFlyUser();
        return flyMessageService.getMessage(null,flyUser.getId(),pageNum,pageSize);
    }
    @PostMapping("sendMessage")
    @ResponseBody
    public JsonResult sendMessage(String content,Integer receiveId,Integer parentId){
        return  flyMessageService.add(content,receiveId,parentId);
    }

    @PostMapping("replyMessage")
    @ResponseBody
    public JsonResult replyMessage(String content,Integer parentId){
        return flyMessageService.reply(content,parentId);
    }

    @ResponseBody
    @PostMapping("unRead")
    public JsonResult getUnReadMessageCount(){
        return flyMessageService.getUnReadMessageCount();
    }


    @GetMapping("attention")
    @ResponseBody
    public JsonResult attention(Integer type,Integer toUserId){
        return flyUserService.attention(type,toUserId);
    }
}
