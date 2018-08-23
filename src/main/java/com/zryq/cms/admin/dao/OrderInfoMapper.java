package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.OrderInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 18:03
 * To change this template use File | Settings | File Templates.
 */
public interface OrderInfoMapper extends Mapper<OrderInfo> {

    List<OrderInfo>  selectOrderInfos(OrderInfo orderInfo);
}
