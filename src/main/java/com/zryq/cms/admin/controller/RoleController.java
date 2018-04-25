package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.Role;
import com.zryq.cms.admin.service.RoleService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Role;
import com.zryq.cms.admin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 角色控制器（用户角色的分派）
 * Created by lollipop on 17/11/9
 */
@RequestMapping("role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("index")
    public String index() {
        return "admin/role_index";
    }

    @GetMapping("data")
    @ResponseBody
    public LayUiData<Role> data(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo pageInfo = roleService.getByPaging(pageNum, pageSize);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }

    @GetMapping("{roleId}")
    public String assignUsers(@PathVariable Integer roleId, Model model) {
        model.addAttribute("role", roleService.getWithUserListById(roleId));
        return "";
    }

    @GetMapping("assignUsers")
    @ResponseBody
    public JsonResult assignUsers(Integer roleId, Integer[] userIds) {
        JsonResult jsonResult = new JsonResult();
        roleService.assignUsers(roleId, userIds);
        return jsonResult;
    }

    @PostMapping("{roleId}")
    @ResponseBody
    public Role getWithUserListById(@PathVariable Integer roleId) {
        return roleService.getWithUserListById(roleId);
    }

}
