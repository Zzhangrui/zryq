package com.zryq.cms.admin.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zryq.cms.admin.dao.MetalDetailLogMapper;
import com.zryq.cms.admin.entity.MetalDetailLog;
import com.zryq.cms.common.data.EChartsData;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.jstree.JsonResultEnum;
import com.zryq.cms.common.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MetalDetailLogService extends BaseService<MetalDetailLogMapper,MetalDetailLog>{

    @Autowired
    private MetalDetailLogMapper metalDetailLogMapper;

    public JsonResult selectAll(Date startTime,Date endTime,Integer metalDetailId){
        MetalDetailLog metalDetailLog = new MetalDetailLog();
        metalDetailLog.setMetalDetailId(metalDetailId);
        Example example = new Example(MetalDetailLog.class);
        example.setOrderByClause("create_time ASC");
        Example.Criteria criteria = example.or();
        criteria.andEqualTo("metalDetailId",metalDetailId);
        if(null!=startTime){
            criteria.andGreaterThanOrEqualTo("startTime",startTime);
        }
        if(null!= endTime){
            criteria.andLessThanOrEqualTo("endTime",endTime);
        }
        List<MetalDetailLog> metalDetailLogList = metalDetailLogMapper.selectByExample(example);
        EChartsData eChartsData = new EChartsData();
        if(metalDetailLogList != null && !metalDetailLogList.isEmpty()){

            List<String> xAxisData = Lists.newArrayList();
            List<Double> yAxisData = Lists.newArrayList();
            metalDetailLogList.forEach(metalDetailLog1 -> {

                xAxisData.add(DateUtil.Date2String(metalDetailLog1.getCreateTime()));
                yAxisData.add(metalDetailLog1.getMetalPrice());
            });
            eChartsData.setxAxisData(xAxisData.toArray());
            eChartsData.setyAxisData(yAxisData.toArray());
        }
        JsonResult jsonResult = new JsonResult(JsonResultEnum.SUCCESS,true);
        jsonResult.setData(eChartsData);
        return jsonResult;
    }
}
