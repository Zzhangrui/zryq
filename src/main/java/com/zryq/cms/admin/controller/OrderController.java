package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.service.MetalDetailService;
import com.zryq.cms.admin.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/7/2
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private MetalDetailService metalDetailService;

    @GetMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("metalList",metalDetailService.selectAll());
        return modelAndView;
    }
}
