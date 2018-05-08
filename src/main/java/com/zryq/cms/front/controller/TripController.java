package com.zryq.cms.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/8
 * Time: 9:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("trip")
public class TripController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("front/trip/index");
        return modelAndView;
    }
}
