package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.service.WebInfService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.entity.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 锐 on 2017/10/20.
 */
@Controller
@RequestMapping("web")
public class WebInfoController {

    @Autowired
    private WebInfService webInfService;


    @RequestMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/web_index");
        return modelAndView;
    }


    @RequestMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, String name) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        PageInfo pageInfo = webInfService.selectWebInfoData(pageNum, pageSize, name);
        LayUiData data = new LayUiData();
        data.setCode("0");
        data.setCount(Integer.valueOf(String.valueOf(pageInfo.getTotal())));
        data.setData(pageInfo.getList());
        return data;
    }

    @RequestMapping("add_show")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("admin/web_add");
        modelAndView.addObject("url", "add_submit");
        return modelAndView;
    }

    @RequestMapping("add_submit")
    @ResponseBody
    public JsonResult submitAdd(WebInfo webInfo) {
        JsonResult jsonResult = new JsonResult();
        webInfService.add(webInfo);
        jsonResult.setSuccess(true);

        return jsonResult;
    }



    @RequestMapping("modify_show/{id}")
    public ModelAndView showModify(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("admin/web_modify");
        WebInfo webInfo = webInfService.selectById(id);
        modelAndView.addObject("webInfo", webInfo);
        modelAndView.addObject("url", "modify_submit");
        return modelAndView;
    }

    @RequestMapping("modify_submit")
    @ResponseBody
    public JsonResult submitModify(WebInfo webInfo) {
        JsonResult jsonResult = new JsonResult();
        webInfService.modifyById(webInfo);
        jsonResult.setSuccess(true);
        return jsonResult;

    }


    /**
     * 获取网站信息
     *
     * @return
     */
    @RequestMapping("getWebInfo")
    @ResponseBody
    public JsonResult getWebInfo() {
        JsonResult jsonResult = new JsonResult();
        List<WebInfo> webInfoList = webInfService.selectWebInfo(null);
        jsonResult.setSuccess(true);
        jsonResult.setData(webInfoList);
        return jsonResult;
    }

}
