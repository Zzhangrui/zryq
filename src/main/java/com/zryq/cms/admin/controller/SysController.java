package com.zryq.cms.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 锐 on 2017/11/10.
 * 系统管理controller
 */
@Controller
@RequestMapping("sys")
public class SysController {



    @RequestMapping("temp/lib")
    public ModelAndView tempLibIndex() {
        ModelAndView modelAndView = new ModelAndView("admin/temp_lib_index");
        return modelAndView;

    }
}
