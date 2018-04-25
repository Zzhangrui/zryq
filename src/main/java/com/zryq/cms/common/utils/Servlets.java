package com.zryq.cms.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shawn on 2017/6/5.
 */
public class Servlets {

    public static HttpServletRequest getRequest() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isStaticFile(String uri) {
        return false;
    }

    public static boolean isViewFile() {
        return false;
    }

}
