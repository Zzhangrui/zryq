package com.zryq.cms.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/27
 * Time: 18:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("fly")
public class FlyLoginController {

    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("fly/login");
        return modelAndView;
    }
}
