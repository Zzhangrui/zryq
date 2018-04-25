package com.zryq.cms.config.interceptor;


import org.apache.logging.log4j.LogManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

/**
 * Created by Gong on 2016/12/21.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    org.apache.logging.log4j.Logger logger = LogManager.getLogger(this);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        logger.debug("管理员操作22.." + url);
        HttpSession session = request.getSession();
        // Person person = (Person)session.getAttribute("person");
        Object user = request.getSession().getAttribute("user");
        //Person person = new BaseController().currentPerson();
        /*if(person==null){
            try {
                //TODO 地址

                response.sendRedirect("/user/login");
            } catch (Exception e) {
               e.printStackTrace();
            }

            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
