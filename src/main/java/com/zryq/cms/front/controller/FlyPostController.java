package com.zryq.cms.front.controller;

import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.FlyPost;
import com.zryq.cms.admin.service.FlyPostService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.enums.FlyPostConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/30
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("fly/post")
public class FlyPostController {

    @Autowired
    private FlyPostService flyPostService;

    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("fly/post_index");
        modelAndView.addObject("categoryList", FlyPostConstant.PostCategory.values());
        return modelAndView;
    }

    @PostMapping("data")
    @ResponseBody
    public PageInfo data(Integer pageNum, Integer pageSize, FlyPost flyPost) {
        return flyPostService.data(pageNum, pageSize, flyPost);
    }

    @GetMapping("edit")
    public ModelAndView edit(Integer id) {
        ModelAndView modelAndView = new ModelAndView("fly/center_post_edit");
        FlyPost flyPost = flyPostService.getEdit(id);
        if (null != id && null != flyPost) {
            modelAndView.addObject("flyPost", flyPost);
        }

        modelAndView.addObject("categoryList", FlyPostConstant.PostCategory.values());
        return modelAndView;
    }

    @PostMapping("edit")
    @ResponseBody
    public JsonResult edit(FlyPost flyPost) {
        return flyPostService.edit(flyPost);
    }

    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer id) {
        return flyPostService.delete(id);
    }

    @GetMapping("detail/{id}")
    public ModelAndView detail(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("fly/post_detail");
        modelAndView.addObject("post",flyPostService.detail(id));
        return modelAndView;
    }
}
