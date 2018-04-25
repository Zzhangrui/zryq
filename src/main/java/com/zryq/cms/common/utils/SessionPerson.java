package com.zryq.cms.common.utils;

import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.entity.User;

/**
 * Created by Shawn on 2017/8/12.
 */
public class SessionPerson {

    public static void save(User user) {
        Servlets.getRequest().getSession().setAttribute("currentUser", user);
    }

    public static User current() {
        Object object = Servlets.getRequest().getSession().getAttribute("currentUser");
        if (object != null) {
            User user = (User) object;
            return user;
        }
        return null;
    }


    /**
     * 获取保存在session的站点Id
     *
     * @return
     */
    public static Integer getWebId() {
        Object object = Servlets.getRequest().getSession().getAttribute("userWebId");
        if (object != null) {
            Integer userWebId = (Integer) object;
            return userWebId;
        }
        return null;
    }
}
