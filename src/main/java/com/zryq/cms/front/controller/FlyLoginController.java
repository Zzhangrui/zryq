package com.zryq.cms.front.controller;

import com.zryq.cms.admin.entity.FlyUser;
import com.zryq.cms.admin.service.FlyUserService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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


    @Autowired
    private FlyUserService flyUserService;

    @RequestMapping("login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("fly/login");
        return modelAndView;
    }

    @PostMapping("login")
    @ResponseBody
    public JsonResult login(String email,String password,String verifyCode){
        return  flyUserService.login(email,password,verifyCode);
    }

    @PostMapping("register")
    @ResponseBody
    public JsonResult register(FlyUser flyUser,String verifyCode){
        return flyUserService.register(flyUser,verifyCode);
    }

    @GetMapping("logout")
    public ModelAndView logout(HttpServletRequest request){
        request.getSession().invalidate();
        ModelAndView modelAndView = new ModelAndView("fly/login");
        return modelAndView;
    }
}
