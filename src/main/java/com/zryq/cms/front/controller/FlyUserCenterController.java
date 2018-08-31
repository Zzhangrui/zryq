package com.zryq.cms.front.controller;

import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.admin.service.ColumnService;
import com.zryq.cms.admin.service.FlyUserService;
import com.zryq.cms.common.data.FileAttr;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.Servlets;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("/fly/center_index");
        return modelAndView;
    }

    @PostMapping("selfArticle")
    @ResponseBody
    public PageInfo getSelfArticle(Integer pageNum,Integer pageSize){

        return articleService.getSelfArticle(pageNum,pageSize);
    }

    @PostMapping("selfLike")
    @ResponseBody
    public PageInfo getSelfLikeArticle(Integer pageNum,Integer pageSize){
        return articleService.getSelfLikeArticle(pageNum,pageSize);
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
}
