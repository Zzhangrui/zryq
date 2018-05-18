package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.RoleMapper;
import com.zryq.cms.admin.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by lollipop on 17/11/9
 */
public class RoleServiceTest {

    @Autowired
    RoleMapper roleMapper;

    public void testGetWithUserListById() throws Exception {
        Role role = roleMapper.getWithUserListById(1);
        Assert.assertEquals(1, role.getUserList().size());
    }

}
