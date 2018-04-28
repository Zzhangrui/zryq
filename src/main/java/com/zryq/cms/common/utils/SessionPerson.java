package com.zryq.cms.common.utils;

import com.google.common.collect.Lists;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.entity.User;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.HttpServletSession;

import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shawn on 2017/8/12.
 */
public class SessionPerson {

    public static Map<String, List<Session>> ONLINE_USER_MAP = Collections.synchronizedMap(new HashMap<String, List<Session>>());

    public static void save(User user) {
        Servlets.getRequest().getSession().setAttribute("currentUser", user);

        List<Session> sessionList = ONLINE_USER_MAP.get(user.getId().toString());
        if(CollectionUtils.isEmpty(sessionList)){
            sessionList = Lists.newArrayList();
        }
        sessionList.add(SecurityUtils.getSubject().getSession());
        ONLINE_USER_MAP.put(user.getId().toString(), sessionList);
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

    /**
     * 踢人
     * @param userId
     * @param removeSessionId
     */
    public static void kickOnlineUser(String userId,String removeSessionId){
        List<Session> sessionList = ONLINE_USER_MAP.get(userId);
        List<Session> removeSession = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(sessionList)){
            sessionList.forEach(session -> {
                if(Strings.isNotEmpty(removeSessionId)){
                    if(session.getId().equals(removeSessionId)){
                        removeSession.add(session);
                        session.stop();
                        return;
                    }
                }else{
                    session.stop();
                }
            });
        }
        if(Strings.isNotEmpty(removeSessionId)){  //只删除一个
            sessionList.removeAll(removeSession);
            ONLINE_USER_MAP.put(userId,sessionList);
        }else{ //全部删除
            ONLINE_USER_MAP.remove(userId);
        }
    }

    public static void main(String[] args) {
        kickOnlineUser("1",null);
    }
}
