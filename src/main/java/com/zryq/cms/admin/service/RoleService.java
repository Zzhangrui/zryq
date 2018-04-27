package com.zryq.cms.admin.service;

import com.google.common.collect.Lists;
import com.zryq.cms.admin.dao.*;
import com.zryq.cms.admin.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.RoleMapper;
import com.zryq.cms.admin.dao.RoleRelationshipMapper;
import com.zryq.cms.admin.dao.UserMapper;
import com.zryq.cms.admin.entity.RoleRelationshipExample;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.common.utils.CheckListUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import tk.mybatis.mapper.entity.Example;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 角色相关业务逻辑处理
 * Created by lollipop on 17/11/9
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleRelationshipMapper roleRelationshipMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private PermissionRoleMapper permissionRoleMapper;

    /**
     * 分页获取所有的角色
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo getByPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RoleExample example = new RoleExample();
        List<Role> roleList = roleMapper.selectByExample(example);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        return pageInfo;
    }

    /**
     * 根据角色Id获取信息（包括该角色下的所有用户）
     *
     * @param id
     * @return
     */
    public Role getWithUserListById(Integer id) {
        return roleMapper.getWithUserListById(id);
    }

    /**
     * 角色分配
     *
     * @param roleId
     * @param userIdArrays
     */
    @Transactional
    public boolean assignUsers(Integer roleId, Integer[] userIdArrays) {
        List<User> beforeUserList = roleMapper.getWithUserListById(roleId).getUserList();
        List<Integer> before = new ArrayList<>();
        List<Integer> after = Arrays.asList(userIdArrays);
        boolean result = true;
        // 之前该用户未分配给任何用户
        try {
            if (beforeUserList == null || beforeUserList.size() == 0) {
                if (after != null && after.size() > 0) {
                    RoleRelationship roleRelationship = new RoleRelationship();
                    roleRelationship.setRoleId(roleId);
                    after.forEach(userId -> {
                        User user = userMapper.selectByPrimaryKey(userId);
                        roleRelationship.setUserId(userId);
                        roleRelationship.setGroupId(user.getGroupId());
                        roleRelationshipMapper.insert(roleRelationship);
                    });
                }
                return true;
            } else {
                //取消之前该角色的所有分配
                if (after == null && after.size() == 0) {
                    beforeUserList.forEach(user -> {
                        RoleRelationshipExample example = new RoleRelationshipExample();
                        example.or().andRoleIdEqualTo(roleId).andUserIdEqualTo(user.getId()).andGroupIdEqualTo(user.getGroupId());
                        roleRelationshipMapper.deleteByExample(example);
                    });
                    return true;
                } else {
                    beforeUserList.forEach(user -> {
                        before.add(user.getId());
                    });
                    //取消部分之前分配的用户
                    before.forEach(userId -> {
                        if (!after.contains(userId)) {
                            RoleRelationshipExample example = new RoleRelationshipExample();
                            example.or().andUserIdEqualTo(userId).andRoleIdEqualTo(roleId).andGroupIdEqualTo(userMapper.selectByPrimaryKey(userId).getGroupId());
                            roleRelationshipMapper.deleteByExample(example);
                        }
                    });
                    //新增一些分配
                    RoleRelationship relationship = new RoleRelationship();
                    relationship.setRoleId(roleId);
                    after.forEach(userId -> {
                        if (!before.contains(userId)) {
                            relationship.setUserId(userId);
                            relationship.setGroupId(userMapper.selectByPrimaryKey(userId).getGroupId());
                            roleRelationshipMapper.insert(relationship);
                        }
                    });
                    return true;
                }
            }
        } catch (Exception e) {
            result = false;
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } finally {
            return result;
        }
    }

    public List<Role> findAll() {
        return roleMapper.selectByExample(new RoleExample());
    }

    public List<Permission> findAllPermission(){
        return permissionMapper.selectAll();
    }

    @Transactional
    public boolean insert(Role role,String permissionIds){
        Integer roleId = roleMapper.insert(role);
        if(Strings.isNotBlank(permissionIds)){
            List<String> permissionIdList = Arrays.asList(permissionIds.split(","));
            permissionIdList.forEach(permissionId ->{
                PermissionRole permissionRole = new PermissionRole();
                permissionRole.setRoleId(roleId);
                permissionRole.setPermissionId(Integer.valueOf(permissionId));
                permissionRoleMapper.insert(permissionRole);
            });
        }
        return true;
    }

    @Transactional
    public boolean modify(Role role,String permissionIds){
        roleMapper.updateByPrimaryKeySelective(role);
        Role hisRole = findPermissionByRoleId(role.getId());
        List<Permission> permissionList = hisRole.getPermissionList();
        List<Integer> oldPermissionIds = Lists.newArrayList();
        permissionList.forEach(permission ->{
            oldPermissionIds.add(permission.getId());
        });
        List<String> permissionIdList = Arrays.asList(permissionIds.split(","));
        List<Integer> newPermissionIds = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(permissionIdList)){
            permissionIdList.forEach(s->{
                newPermissionIds.add(Integer.valueOf(s));
            });
        }
        Map<String ,List<Integer>> result = CheckListUtil.getDiffrent(oldPermissionIds,newPermissionIds);
        List<Integer> addList = result.get(CheckListUtil.ADD);
        List<Integer> removeList = result.get(CheckListUtil.REMOVE);
        if(CollectionUtils.isNotEmpty(addList)){
            addList.forEach(add->{
                PermissionRole permissionRole = new PermissionRole();
                permissionRole.setPermissionId(add);
                permissionRole.setRoleId(role.getId());
                permissionRoleMapper.insert(permissionRole);
            });
        }
        if(CollectionUtils.isNotEmpty(removeList)){
            Example example = new Example(PermissionRole.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("role_id",role.getId()).andIn("permission_id",removeList);
            permissionRoleMapper.deleteByExample(example);
        }
        return true;
    }

    public Role findPermissionByRoleId(Integer roleId){
        return roleMapper.selectPermissionByRoleId(roleId);
    }
}
