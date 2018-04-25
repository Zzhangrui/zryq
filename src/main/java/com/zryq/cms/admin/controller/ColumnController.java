package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.service.ColumnService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 锐 on 2017/11/1.
 */
@Controller
@RequestMapping("column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @RequestMapping("index")
    public ModelAndView index(Integer webId, Integer columnId) {
        ModelAndView modelAndView = new ModelAndView("admin/column_index");
        return modelAndView;
    }


    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, Integer webId, Integer parentId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        webId = SessionPerson.getWebId(); //获取站点
        PageInfo pageInfo = columnService.selectColumnData(pageNum, pageSize, parentId, webId);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());

        return data;
    }

    @RequestMapping("add_show")
    public ModelAndView showAdd(Integer parentId) {
        ModelAndView modelAndView = new ModelAndView("admin/column_add");
        modelAndView.addObject("parentId", parentId);
        modelAndView.addObject("url", "add_submit");
        return modelAndView;
    }

    @RequestMapping("add_submit")
    @ResponseBody
    public JsonResult submitAdd(Column column) {
        JsonResult jsonResult = new JsonResult();
        columnService.add(column);
        jsonResult.setSuccess(true);
        return jsonResult;
    }


    @RequestMapping("modify_show/{id}")
    public ModelAndView showModify(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/column_modify");
        Column column = columnService.selectById(id);
        modelAndView.addObject("column", column);
        modelAndView.addObject("url", "modify_submit");
        return modelAndView;
    }

    @RequestMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(Column column) {
        JsonResult jsonResult = new JsonResult();
        columnService.modifyById(column);
        jsonResult.setSuccess(true);
        return jsonResult;
    }

    @RequestMapping("delete")
    @ResponseBody
    public JsonResult deleteByIds(String ids) {

        JsonResult jsonResult = new JsonResult();

        columnService.deleteByIds(ids);
        jsonResult.setSuccess(true);
        return jsonResult;

    }


    /**
     * 生成站点id的机构树
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("tree")
    public String tree() {
        return columnService.tree(SessionPerson.getWebId());
    }
}
