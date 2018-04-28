package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.RoleRelationshipMapper;
import com.zryq.cms.admin.dao.UserMapper;
import com.zryq.cms.admin.entity.*;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.utils.MD5;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.zryq.cms.admin.dao.RoleRelationshipMapper;
import com.zryq.cms.admin.dao.UserMapper;
import com.zryq.cms.admin.entity.RoleRelationship;
import com.zryq.cms.admin.entity.RoleRelationshipExample;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.entity.UserExample;
import com.zryq.cms.common.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * Created by 锐 on 2017/10/19.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRelationshipMapper roleRelationshipMapper;

    public boolean add(User user, Integer roleId) {
        if (user == null) {
            return false;
        }
        String password = "111111";
        password = MD5.MD5Encode(password);
        user.setPassword(password);
        userMapper.insert(user);
        RoleRelationship roleRelationship = new RoleRelationship();
        roleRelationship.setUserId(user.getId());
        roleRelationship.setGroupId(user.getGroupId());
        roleRelationship.setRoleId(roleId);
        return roleRelationshipMapper.insert(roleRelationship) > 0;
    }

    public boolean deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean modifyById(User user, Integer roleId) {
        RoleRelationshipExample example = new RoleRelationshipExample();
        example.or().andUserIdEqualTo(user.getId());
        RoleRelationship roleRelationship = roleRelationshipMapper.selectByExample(example).get(0);
        roleRelationship.setRoleId(roleId);
        roleRelationshipMapper.updateByPrimaryKey(roleRelationship);
        return userMapper.updateByPrimaryKeySelective(user) > 0;
    }

    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();

        criteria.andUsernameEqualTo(username);

        List<User> userList = userMapper.selectByExample(userExample);

        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    public List<User> selectList(Integer webId, String username, String trueName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.or();
        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        if (!Strings.isNullOrEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (!Strings.isNullOrEmpty(trueName)) {
            criteria.andTrueNameLike("%" + trueName + "%");
        }
        return userMapper.selectByExample(userExample);
    }


    public PageInfo getByPaging(Integer pageNum, Integer pageSize, String username) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        if (username != null) {
            example.or().andUsernameLike("%" + username + "%");
        }
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /**
     * 批量删除用户
     *
     * @param userIds
     * @return
     */
    public boolean deleteBatch(Integer[] userIds) {
        return userMapper.deleteBatch(Arrays.asList(userIds)) > 0;
    }

    public User getWithRoleListById(Integer userId) {
        return userMapper.getWithRoleListById(userId);
    }

    public JsonResult modifySelf(User currentUser,String trueName,String oldPassword,String newPassword1,String newPassword2){
        User user = new User();
        user.setId(currentUser.getId());
        user.setTrueName(trueName);
        if(org.apache.logging.log4j.util.Strings.isNotEmpty(newPassword1)){
            if(!(org.apache.logging.log4j.util.Strings.isNotEmpty(oldPassword) && currentUser.getPassword().equals(MD5.MD5Encode(oldPassword)))){
                JsonResult jsonResult = JsonResult.FAIL;
                jsonResult.setMessage("原始密码不正确，请重新输入");
                return jsonResult;
            }
            if(!newPassword1.equals(newPassword2)){
                JsonResult jsonResult = JsonResult.FAIL;
                jsonResult.setMessage("两次密码不一致，请重新输入");
                return jsonResult;
            }
            user.setPassword(MD5.MD5Encode(newPassword1));
        }
        userMapper.updateByPrimaryKeySelective(user);
        JsonResult jsonResult = JsonResult.SUCCESS;

        return jsonResult;
    }
}
