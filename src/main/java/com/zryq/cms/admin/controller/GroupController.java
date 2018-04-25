package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.Group;
import com.zryq.cms.admin.service.GroupService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by lenovo on 2017-11-6.
 */
@Controller
@RequestMapping("group")
public class GroupController extends BaseController {
    @Autowired
    private GroupService groupService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/group_index");
        return modelAndView;
    }

    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, String title, Integer parentId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageInfo pageInfo =
                groupService.selectGroupData(pageNum, pageSize, SessionPerson.getWebId(), title, parentId);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }

    @RequestMapping("add_show")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("admin/group_add");
        modelAndView.addObject("url", "add_submit");

        List<Group> groupList = groupService.selectWebGroup(SessionPerson.getWebId(), null);
        modelAndView.addObject("groupList", groupList);
        return modelAndView;

    }

    @RequestMapping("add_submit")
    @ResponseBody
    public JsonResult submitAdd(Group group) {

        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("编辑成功");
        groupService.add(group);
        jsonResult.setSuccess(true);
        return jsonResult;

    }

    @RequestMapping("modify_show/{id}")
    public ModelAndView showModify(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/group_modify");
        Group group = groupService.selectById(id);
        modelAndView.addObject("group", group);
        modelAndView.addObject("url", "modify_submit");

        List<Group> groupList = groupService.selectWebGroup(SessionPerson.getWebId(), id);
        modelAndView.addObject("groupList", groupList);
        return modelAndView;
    }

    @RequestMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(Group group) {
        JsonResult jsonResult = new JsonResult();
        groupService.modifyById(group);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JsonResult updateState(Integer id) {
        JsonResult jsonResult = new JsonResult();
        groupService.deleteById(id);
        jsonResult.setSuccess(true);
        jsonResult.setMessage("删除成功");
        return jsonResult;
    }


    @RequestMapping("tree")
    @ResponseBody
    public String tree() {
        Integer webId = SessionPerson.getWebId();
        return groupService.tree(webId);
    }


}
