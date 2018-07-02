package com.zryq.cms.admin.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.ScrollInfoMapper;
import com.zryq.cms.admin.entity.ScrollInfo;
import com.zryq.cms.common.data.JsonResult;
import com.zryq.cms.common.data.LayUiData;
import com.zryq.cms.common.enums.ScrollConstant;
import com.zryq.cms.common.utils.SessionPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/8
 * Time: 11:04
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ScrollInfoService {

    @Autowired
    private ScrollInfoMapper scrollInfoMapper;

    public LayUiData<ScrollInfo> getScrollInfo(Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Integer webId = SessionPerson.getWebId();
        ScrollInfo scrollInfo = new ScrollInfo();
        scrollInfo.setWebId(webId);
        PageHelper.startPage(pageNum, pageSize);
        List<ScrollInfo> scrollInfoList = scrollInfoMapper.select(scrollInfo);
        PageInfo pageInfo = new PageInfo(scrollInfoList);
        LayUiData layUiData = new LayUiData();
        layUiData.setData(pageInfo.getList());
        layUiData.setCount((int)pageInfo.getTotal());
        layUiData.setCode("0");
        return layUiData;
    }

    public JsonResult add(ScrollInfo scrollInfo) {
        scrollInfo.setUpdateTime(new Date());
        scrollInfo.setCreateTime(new Date());
        scrollInfo.setWebId(SessionPerson.getWebId());
        scrollInfo.setStatus(ScrollConstant.Status.CLOSE.getCode());
        scrollInfoMapper.insert(scrollInfo);
        return JsonResult.SUCCESS;
    }

    public JsonResult updateScrollInfo(ScrollInfo scrollInfo) {
        scrollInfo.setUpdateTime(new Date());
        scrollInfoMapper.updateByPrimaryKeySelective(scrollInfo);
        JsonResult jsonResult = JsonResult.SUCCESS;
        return jsonResult;
    }

    public JsonResult deleteById(Integer id) {
        scrollInfoMapper.deleteByPrimaryKey(id);
        return JsonResult.SUCCESS;
    }

    public ScrollInfo selectById(Integer id) {
        return scrollInfoMapper.selectByPrimaryKey(id);
    }

    public List<ScrollInfo> selectFrontScroll(){
        ScrollInfo scrollInfo = new ScrollInfo();
        scrollInfo.setStatus(ScrollConstant.Status.OPEN.getCode());
        return scrollInfoMapper.select(scrollInfo);
    }

}
