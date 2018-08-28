package com.zryq.cms.common.utils;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
public class SessionUtil {

    public static void setValue(String key,Object value){
        Servlets.getRequest().getSession().setAttribute(key , value);
    }

    public static Object getValue(String key){
        return Servlets.getRequest().getSession().getAttribute(key);
    }

}
