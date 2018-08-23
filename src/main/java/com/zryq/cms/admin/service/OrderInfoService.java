package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.OrderInfoMapper;
import com.zryq.cms.admin.entity.OrderInfo;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderInfoService extends BaseService<OrderInfoMapper, OrderInfo> {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    public LayUiData<OrderInfo> data(Integer pageNum, Integer pageSize, OrderInfo orderInfo) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<OrderInfo> orderInfoList = orderInfoMapper.select(orderInfo);
        PageInfo pageInfo = new PageInfo(orderInfoList);
        LayUiData layUiData = new LayUiData();
        layUiData.setData(pageInfo.getList());
        layUiData.setCount((int) pageInfo.getTotal());
        layUiData.setCode(layUiData.SUEECSS_CODE);
        return layUiData;
    }

    public JsonResult add(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo);
        return JsonResult.SUCCESS;
    }

    public JsonResult modify(OrderInfo orderInfo) {
        orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
        return JsonResult.SUCCESS;
    }

}
