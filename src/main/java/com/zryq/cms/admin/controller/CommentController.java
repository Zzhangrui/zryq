package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.Comment;
import com.zryq.cms.admin.service.CommentService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2017-11-10.
 */
@Controller
@RequestMapping("comment")
public class CommentController extends BaseController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/comment_index");
        return modelAndView;
    }

    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, String title, String search) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageInfo pageInfo = commentService.selectArticleData(pageNum, pageSize, title, search);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }


    @RequestMapping("modify_show/{id}")
    public ModelAndView showModify(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/comment_modify");
        modelAndView.addObject("url", "modify_submit");
        return modelAndView;
    }

    @RequestMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(Comment comment) {
        JsonResult jsonResult = new JsonResult();
        commentService.modifyById(comment);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    @RequestMapping("update/{id}/{state}")
    @ResponseBody
    public JsonResult updateState(@PathVariable("id") Integer id, @PathVariable("state") Integer state) {
        JsonResult jsonResult = new JsonResult();
        commentService.updateState(id, state);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

}
