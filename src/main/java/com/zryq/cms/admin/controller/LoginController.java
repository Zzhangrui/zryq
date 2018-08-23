package com.zryq.cms.admin.controller;

import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.jstree.JsonResultEnum;
import com.zryq.cms.common.utils.MD5;
import com.zryq.cms.common.utils.MD5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 锐 on 2017/3/29.
 */
@Controller
public class LoginController extends BaseController {

    //@Autowired
    //private UserService userService;



    /**
     * 默认跳转
     *
     * @return
     */
    @RequestMapping("/")
    public ModelAndView welcome() {
        return new ModelAndView(new RedirectView("login"));
    }


    /**
     * 打开登陆
     *
     * @return
     */
    @RequestMapping(value = "login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("admin/login");
        modelAndView.addObject("url", "dologin.do");
        return modelAndView;
    }


    @RequestMapping(value = "test")
    @ResponseBody
    public JsonResult test(Date test) {
        System.out.println(test);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    /**
     * 登陆提交
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "dologin", method = {RequestMethod.POST})
    @ResponseBody
    public JsonResult dologin(String username, String password, HttpServletRequest req, HttpServletResponse res) {
        JsonResult jsonResult = new JsonResult();
        if (username == null || password == null || username.length() < 1
                || password.length() < 1) {
            return new JsonResult(JsonResultEnum.LOGIN_EMPTY, false);
        }
        password = MD5.MD5Encode(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(false);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            jsonResult.setSuccess(true);
            return jsonResult;
        } catch (UnknownAccountException uae) {
            return new JsonResult(JsonResultEnum.PASSWORD_ERROR, false);
        } catch (IncorrectCredentialsException ice) {

            return new JsonResult(JsonResultEnum.PASSWORD_ERROR, false);
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
            return new JsonResult(JsonResultEnum.PASSWORD_ERROR, false);
        }
        //验证是否登录成功
       /* if(currentUser.isAuthenticated()){
            System.out.println("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        }else{
            token.clear();
        }*/


        /*Person person = personService.selectByUniqId(username);
        if(person ==null){
            jsonResult.markError("账号或密码不正确");
            return  jsonResult;
        }
        boolean isSuccess = person.getPassword().equals(MD5.MD5Encode(password));
        if (isSuccess){
            *//*if(user.getState() !=1){
                jsonResult.markError("账号状态异常，请联系管理员");
                return  jsonResult;
            }
            saveUser(req,user);*//*
            savePerson(req,person);

            //userMap.put(user.getUsername(),user);
            jsonResult.setSuccess(true);
            return  jsonResult;
        }else{
            jsonResult.markError("账号或密码不正确");
            return  jsonResult;
        }*/


    }

    /**
     * 退出
     *
     * @param req
     * @return
     */
    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView(new RedirectView("login"));
        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }
        return modelAndView;
    }

}
