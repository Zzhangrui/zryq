package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.MetalDetailLogMapper;
import com.zryq.cms.admin.dao.MetalDetailMapper;
import com.zryq.cms.admin.entity.MetalDetail;
import com.zryq.cms.admin.entity.MetalDetailLog;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 18:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class MetalDetailService extends BaseService<MetalDetailMapper,MetalDetail>{

    @Autowired
    private MetalDetailMapper metalDetailMapper;

    @Autowired
    private MetalDetailLogMapper metalDetailLogMapper;

    public JsonResult insert(MetalDetail metalDetail){
        metalDetail.setCreateTime(new Date());
        metalDetail.setUpdateTime(new Date());
        metalDetailMapper.insert(metalDetail);
        MetalDetailLog metalDetailLog = convertToLog(metalDetail);
        metalDetailLogMapper.insert(metalDetailLog);
        return JsonResult.SUCCESS;
    }

    public JsonResult update(MetalDetail metalDetail){
        metalDetail.setUpdateTime(new Date());
        metalDetailMapper.updateByPrimaryKeySelective(metalDetail);
        MetalDetailLog metalDetailLog = convertToLog(metalDetail);
        metalDetailLogMapper.insert(metalDetailLog);
        return JsonResult.SUCCESS;
    }

    public JsonResult delete(Integer id){
        MetalDetail metalDetail = new MetalDetail();
        metalDetail.setId(id);
        metalDetailMapper.deleteByPrimaryKey(metalDetail);
        return JsonResult.SUCCESS;
    }

    public LayUiData<MetalDetail> getMetalDetail(Integer pageNum, Integer pageSize,MetalDetail metalDetail) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<MetalDetail> metalDetailList = metalDetailMapper.selectMetalDetails(metalDetail);
        PageInfo pageInfo = new PageInfo(metalDetailList);
        LayUiData layUiData = new LayUiData();
        layUiData.setData(pageInfo.getList());
        layUiData.setCount((int)pageInfo.getTotal());
        layUiData.setCode(layUiData.SUEECSS_CODE);
        return layUiData;
    }

    private MetalDetailLog convertToLog(MetalDetail metalDetail){
        MetalDetailLog metalDetailLog = new MetalDetailLog();
        metalDetailLog.setCateId(metalDetail.getCateId());
        metalDetailLog.setMetalDetailId(metalDetail.getId());
        metalDetailLog.setMetalModel(metalDetail.getMetalModel());
        metalDetailLog.setMetalPrice(metalDetail.getMetalPrice());
        metalDetailLog.setMetalName(metalDetail.getMetalName());
        metalDetailLog.setCreateTime(new Date());
        metalDetailLog.setUpdateTime(new Date());
        return metalDetailLog;
    }



}
