package com.zryq.cms.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/4/25
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("admin")
public class IndexController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("admin/index");
        return modelAndView;
    }
}
