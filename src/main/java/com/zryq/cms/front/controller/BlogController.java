package com.zryq.cms.front.controller;

import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.Comment;
import com.zryq.cms.admin.service.ArticleService;
import com.zryq.cms.admin.service.CommentService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/24
 * Time: 14:30
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("index")
    public ModelAndView index(String artTitle){
        ModelAndView modelAndView = new ModelAndView("blog/index");
        modelAndView.addObject("title",artTitle);
        return modelAndView;
    }

    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum,Integer pageSize,Article article){
        return  articleService.blogIndexData(pageNum,pageSize,article);
    }

    @RequestMapping("detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("blog/detail");
        modelAndView.addObject("article",articleService.blogDetail(id));
        return modelAndView;
    }

    @PostMapping("doLike")
    @ResponseBody
    public JsonResult doLike(Integer id){
        return articleService.doLike(id);
    }

    @PostMapping("submitComment")
    @ResponseBody
    public JsonResult submitComment(Comment comment){
        return commentService.add(comment);
    }

    @PostMapping("getComment")
    @ResponseBody
    public PageInfo getComment(Integer id, Integer pageNum){
        return commentService.getBlogComment(null,pageNum,id);
    }

}
