package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by Gong on 2016/12/21.
 */
public class BaseController {

    static String VIEW_PREFIX = "_admin/";
    static String LOGIN_USER = "user";
    static String MESSAGE = "message";
    //public static Map<String,User> userMap = new Hashtable<String,User>();



    /**
     * 保存person到session中
     *
     * @param req
     * @param user
     */
    protected void saveUser(HttpServletRequest req, User user) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(7200);
        }
    }



    protected User currentUser() {
        try {
            HttpServletRequest request =
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            return user;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }



}
