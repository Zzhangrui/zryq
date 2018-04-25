package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.service.TemplateService;
import com.zryq.cms.common.data.LayUiData;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 锐 on 2017/11/9.
 * 模板controller
 */
@Controller
@RequestMapping("template")
public class TemplateController {

    @Autowired
    private TemplateService templateService;


    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/template_index");
        return modelAndView;
    }


    /**
     * 获取数据
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @return
     */
    @ResponseBody
    @RequestMapping("data")
    public LayUiData data(Integer pageNum, Integer pageSize, Integer webId) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageInfo pageInfo = templateService.data(pageNum, pageSize, webId);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());

        return data;
    }
}
