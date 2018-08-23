package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.service.GroupService;
import com.zryq.cms.admin.service.RoleService;
import com.zryq.cms.admin.service.UserService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.service.GroupService;
import com.zryq.cms.admin.service.RoleService;
import com.zryq.cms.admin.service.UserService;
import com.zryq.cms.common.utils.MD5;
import com.zryq.cms.common.utils.SessionPerson;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器（用户的增删改查）
 * Created by lollipop on 17/11/9
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("index")
    public String index() {
        return "admin/user_index";
    }

    @GetMapping("data")
    @ResponseBody
    public LayUiData<User> data(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, String username) {
        PageInfo pageInfo = userService.getByPaging(pageNum, pageSize, username);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }


    @GetMapping("add")
    public String add(Model model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "admin/user_add";
    }


    @PostMapping("add")
    @ResponseBody
    public JsonResult add(User user, Integer roleId) {
        JsonResult jsonResult = new JsonResult();
        if (userService.add(user, roleId)) {
            jsonResult.markSuccess("添加成功！", null);
        } else {
            jsonResult.markError("添加失败！");
        }
        return jsonResult;
    }

    @GetMapping("edit/{userId}")
    public String edit(@PathVariable Integer userId, Model model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("roles", roleService.findAll());
        model.addAttribute("user", userService.getWithRoleListById(userId));
        return "admin/user_add";
    }

    @PostMapping("edit")
    @ResponseBody
    public JsonResult edit(User user, Integer roleId) {
        JsonResult jsonResult = new JsonResult();
        if (userService.modifyById(user, roleId)) {
            jsonResult.markSuccess("修改成功！", null);
        } else {
            jsonResult.markError("修改失败！");
        }
        return jsonResult;
    }

    @PostMapping("delete")
    @ResponseBody
    public JsonResult delete(Integer[] userIds) {
        JsonResult jsonResult = new JsonResult();
        if (userIds == null || userIds.length == 0) {
            jsonResult.markError("请至少勾选一个用户！");
            return jsonResult;
        }
        if (userService.deleteBatch(userIds)) {
            jsonResult.markSuccess("删除成功！", null);
        } else {
            jsonResult.markError("删除失败！");
        }
        return jsonResult;
    }

    @GetMapping("self")
    public ModelAndView self(){
        ModelAndView modelAndView = new ModelAndView("admin/user_self");
        User user = SessionPerson.current();
        modelAndView.addObject("self",user);
        return modelAndView;
    }

    @PostMapping("self")
    @ResponseBody
    public JsonResult self(String trueName,String oldPassword,String newPassword1,String newPassword2){
        User currentUser = SessionPerson.current();
        JsonResult jsonResult = userService.modifySelf(currentUser,trueName,oldPassword,newPassword1,newPassword2);
        return jsonResult;
    }
}
