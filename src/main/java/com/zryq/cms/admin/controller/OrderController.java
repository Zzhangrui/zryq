package com.zryq.cms.admin.controller;

import com.zryq.cms.admin.entity.OrderInfo;
import com.zryq.cms.admin.service.MetalDetailService;
import com.zryq.cms.admin.service.OrderInfoService;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/7/2
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("orderInfo")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private MetalDetailService metalDetailService;

    @GetMapping("index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("admin/order_index");
        modelAndView.addObject("metalList", metalDetailService.selectAll());
        return modelAndView;
    }

    @PostMapping("data")
    @ResponseBody
    public LayUiData data(Integer pageNum, Integer pageSize, OrderInfo orderInfo) {
        return orderInfoService.data(pageNum, pageSize, orderInfo);
    }

    @GetMapping("add")
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("admin/order_add");
        return modelAndView;
    }

    @PostMapping("order")
    @ResponseBody
    public JsonResult add(OrderInfo orderInfo) {
        return orderInfoService.add(orderInfo);
    }

    @GetMapping("modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id, OrderInfo orderInfo) {
        ModelAndView modelAndView = new ModelAndView("admin/order_add");
        modelAndView.addObject("orderInfo", orderInfoService.selectByPrimaryKey(orderInfo));
        modelAndView.addObject("metalList", metalDetailService.selectAll());
        return modelAndView;
    }

    @PostMapping("modify")
    @ResponseBody
    public JsonResult modify(OrderInfo orderInfo) {
        return orderInfoService.modify(orderInfo);
    }
}
