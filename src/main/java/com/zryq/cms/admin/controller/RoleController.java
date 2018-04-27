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
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("add_show")
    public ModelAndView showAdd(){
        ModelAndView modelAndView = new ModelAndView("admin/role_add");
        modelAndView.addObject("url","add_submit");
        modelAndView.addObject("permissions",roleService.findAllPermission());
        return modelAndView;
    }

    @PostMapping("add_submit")
    @ResponseBody
    public JsonResult submitAdd(Role role,String permissionIds){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(roleService.insert(role,permissionIds));
        return jsonResult;
    }

    @GetMapping("modify_show/{roleId}")
    public ModelAndView showModify(@PathVariable("roleId") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/role_add");
        modelAndView.addObject("url","modify_submit");
        modelAndView.addObject("role",roleService.findPermissionByRoleId(id));
        modelAndView.addObject("permissions",roleService.findAllPermission());
        return modelAndView;
    }

    @PostMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(Role role,String permissionIds){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(roleService.modify(role,permissionIds));
        return jsonResult;
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
