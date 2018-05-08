package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.ScrollInfo;
import com.zryq.cms.admin.service.ScrollInfoService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/8
 * Time: 11:29
 * To change this template use File | Settings | File Templates.
 */
@RequestMapping("scroll")
@Controller
public class ScrollInfoController {

    @Autowired
    private ScrollInfoService scrollInfoService;

    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("admin/scroll_index");
        return modelAndView;
    }

    @GetMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum,Integer pageSize){
        return scrollInfoService.getScrollInfo(pageNum,pageSize);
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("admin/scroll_add");
        modelAndView.addObject("url","add");
        return modelAndView;
    }

    @PostMapping("add")
    @ResponseBody
    public JsonResult add(ScrollInfo scrollInfo){
        return scrollInfoService.add(scrollInfo);
    }

    @GetMapping("edit/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/scroll_add");
        modelAndView.addObject("scrollInfo",scrollInfoService.selectById(id));
        modelAndView.addObject("url","edit");
        return modelAndView;
    }

    @PostMapping("edit")
    @ResponseBody
    public JsonResult modify(ScrollInfo scrollInfo){
        return scrollInfoService.updateScrollInfo(scrollInfo);
    }

    @PostMapping("delete/{id}")
    @ResponseBody
    public JsonResult delete(@PathVariable("id") Integer id){
        return scrollInfoService.deleteById(id);
    }
}
