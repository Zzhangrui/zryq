package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.MetalCategoryMapper;
import com.zryq.cms.admin.entity.MetalCategory;
import com.zryq.cms.admin.entity.ScrollInfo;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Parser;
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
public class MetalCategoryService extends BaseService<MetalCategoryMapper,MetalCategory>{

    @Autowired
    private MetalCategoryMapper metalCategoryMapper;

    public JsonResult insert(MetalCategory metalCategory){
        metalCategory.setCreateTime(new Date());
        metalCategory.setUpdateTime(new Date());
        metalCategoryMapper.insert(metalCategory);
        return JsonResult.SUCCESS;
    }

    public JsonResult update(MetalCategory metalCategory){
        metalCategory.setUpdateTime(new Date());
        metalCategoryMapper.updateByPrimaryKeySelective(metalCategory);
        return JsonResult.SUCCESS;
    }

    public JsonResult deleteById(Integer id){
        MetalCategory metalCategory = new MetalCategory();
        metalCategory.setId(id);
        metalCategoryMapper.deleteByPrimaryKey(metalCategory);
        return JsonResult.SUCCESS;
    }

    public LayUiData<MetalCategory> getMetalCategory(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        List<MetalCategory> metalCategoryList = metalCategoryMapper.select(new MetalCategory());
        PageInfo pageInfo = new PageInfo(metalCategoryList);
        LayUiData layUiData = new LayUiData();
        layUiData.setData(pageInfo.getList());
        layUiData.setCount((int)pageInfo.getTotal());
        layUiData.setCode("0");
        return layUiData;
    }
}
