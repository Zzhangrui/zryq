package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.MetalDetail;
import com.zryq.cms.admin.service.MetalCategoryService;
import com.zryq.cms.admin.service.MetalDetailLogService;
import com.zryq.cms.admin.service.MetalDetailService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/21
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("metalDetail")
public class MetalDetailController {

    @Autowired
    private MetalCategoryService metalCategoryService;

    @Autowired
    private MetalDetailService metalDetailService;

    @Autowired
    private MetalDetailLogService metalDetailLogService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("admin/metal_detail_index");
        modelAndView.addObject("metalCateList",metalCategoryService.selectAll());
        return modelAndView;
    }

    @PostMapping("data")
    @ResponseBody
    public LayUiData<MetalDetail> date(Integer pageNum, Integer pageSize,MetalDetail metalDetail){
        return metalDetailService.getMetalDetail(pageNum,pageSize,metalDetail);
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("admin/metal_detail_add");
        modelAndView.addObject("url","add");
        modelAndView.addObject("metalCateList",metalCategoryService.selectAll());
        return modelAndView;
    }

    @PostMapping("add")
    @ResponseBody
    public JsonResult add(MetalDetail metalDetail){
        return metalDetailService.insert(metalDetail);
    }

    @GetMapping("modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/metal_detail_add");
        MetalDetail metalDetail = new MetalDetail();
        metalDetail.setId(id);
        modelAndView.addObject("url","modify");
        modelAndView.addObject("metalDetail",metalDetailService.selectByPrimaryKey(metalDetail));
        modelAndView.addObject("metalCateList",metalCategoryService.selectAll());
        return modelAndView;
    }

    @PostMapping("modify")
    @ResponseBody
    public JsonResult modify(MetalDetail metalDetail){
        return metalDetailService.update(metalDetail);
    }

    @ResponseBody
    @PostMapping("delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id){
        return metalDetailService.delete(id);
    }

    @GetMapping("view/{id}")
    public ModelAndView view(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/metal_log_index");
        modelAndView.addObject("id",id);
        return modelAndView;
    }

    @PostMapping("view/{id}")
    @ResponseBody
    public JsonResult viewData(@PathVariable("id") Integer id, Date startTime,Date endTime){
        return metalDetailLogService.selectAll(startTime,endTime,id);
    }
}
