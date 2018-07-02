package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.MetalCategory;
import com.zryq.cms.admin.service.MetalCategoryService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/21
 * Time: 11:11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("metalCate")
public class MetalCategoryController {

    @Autowired
    private MetalCategoryService metalCategoryService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("admin/metal_cate_index");
        return modelAndView;
    }

    @PostMapping("data")
    @ResponseBody
    public LayUiData<MetalCategory> date(Integer pageNum,Integer pageSize){
        return metalCategoryService.getMetalCategory(pageNum,pageSize);
    }

    @GetMapping("add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("admin/metal_cate_add");
        modelAndView.addObject("url","add");
        return modelAndView;
    }

    @PostMapping("add")
    @ResponseBody
    public JsonResult add(MetalCategory metalCategory){
        return metalCategoryService.insert(metalCategory);
    }

    @GetMapping("modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/metal_cate_add");
        MetalCategory metalCategory = new MetalCategory();
        metalCategory.setId(id);
        modelAndView.addObject("metalCategory",metalCategoryService.selectByPrimaryKey(metalCategory));
        return modelAndView;
    }

    @PostMapping("modify")
    @ResponseBody
    public JsonResult modify(MetalCategory metalCategory){
        return metalCategoryService.update(metalCategory);
    }

    @ResponseBody
    @PostMapping("delete/{id}")
    public JsonResult delete(@PathVariable("id") Integer id){
        return metalCategoryService.deleteById(id);
    }
}
