package com.zryq.cms.config.realm;

import com.zryq.cms.admin.entity.Role;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 锐 on 2017/8/30.
 */
public class PersonRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()
        String currentUsername = (String) super.getAvailablePrincipal(principals);
        User user = userService.selectByUsername(currentUsername);
        List<String> roleList = new ArrayList<String>();
        //从数据库中获取当前登录用户的详细信息
        //      if(null != person){
        //          //实体类User中包含有用户角色的实体类信息
        //          roleList = roleService.getPersonRoleNameList(person.getId());
        //      }else{
        //          throw new AuthorizationException();
        //      }
        //为当前用户设置角色和权限
        List<Role> roles = userService.getWithRoleListById(user.getId()).getRoleList();
        roles.forEach(role -> {
            roleList.add(role.getRoleName());
        });
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
        simpleAuthorInfo.addRoles(roleList);

        return simpleAuthorInfo;
    }


    /**
     * 验证当前登录的Subject
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        //获取基于用户名和密码的令牌
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        //两个token的引用都是一样的,
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String uni = token.getUsername();
        User user = userService.selectByUsername(uni);
        if (null != user) {
            AuthenticationInfo authcInfo =
                    new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getTrueName());
            this.setSession("currentUser", user);
            this.setSession("userWebId", user.getWebId());
            return authcInfo;
        } else {
            return null;
        }
        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常
    }


    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *
     * @see
     */
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                session.setAttribute(key, value);
                session.setTimeout(7200000);
            }
        }
    }
}
