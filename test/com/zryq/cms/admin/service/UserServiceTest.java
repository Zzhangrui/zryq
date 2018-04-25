package com.zryq.cms.admin.service;

import com.zryq.cms.admin.entity.User;
import com.github.pagehelper.PageInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lollipop on 17/11/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-application.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getByPaging() throws Exception {
        PageInfo pageInfo = userService.getByPaging(1,10, "z");
        Assert.assertEquals(1, pageInfo.getList().size());
    }

    @Test
    public void testGetWithRoleListById() {
        User user = userService.getWithRoleListById(1);
        Assert.assertEquals(2, user.getRoleList().size());
    }

}
