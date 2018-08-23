package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.zryq.cms.admin.dao.OrderInfoMapper;
import com.zryq.cms.admin.entity.OrderInfo;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class OrderInfoService extends BaseService<OrderInfoMapper,OrderInfo> {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    public LayUiData<OrderInfo> data(Integer pageNum, Integer pageSize,OrderInfo orderInfo){
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);

        LayUiData layUiData = new LayUiData();
        return layUiData;
    }



}
