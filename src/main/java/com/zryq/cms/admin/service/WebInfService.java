package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.WebInfoMapper;
import com.zryq.cms.admin.entity.Article;
import com.zryq.cms.admin.entity.ArticleExample;
import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.entity.WebInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.zryq.cms.admin.dao.WebInfoMapper;
import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.entity.WebInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 锐 on 2017/11/1.
 */
@Service
public class WebInfService {

    @Autowired
    private WebInfoMapper webInfoMapper;


    @Autowired
    private ColumnService columnService;


    public boolean add(WebInfo webInfo) {
        webInfoMapper.insert(webInfo);

        if (webInfo.getTempId() == 1) {
            columnService.addGzsDefaultColumn(webInfo.getId());

        }

        return true;

    }

    public boolean deleteById(Integer id) {
        return webInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    public boolean modifyById(WebInfo webInfo) {
        return webInfoMapper.updateByPrimaryKeySelective(webInfo) > 0;
    }

    public PageInfo selectWebInfoData(Integer pageNum, Integer pageSize, String webName) {
        PageHelper.startPage(pageNum, pageSize);
        WebInfoExample webInfoExample = new WebInfoExample();
        WebInfoExample.Criteria criteria = webInfoExample.or();
        if (!Strings.isNullOrEmpty(webName)) {
            criteria.andWebNameLike("%" + webName + "%");
        }
        List<WebInfo> webInfoList = webInfoMapper.selectByExample(webInfoExample);
        PageInfo pageInfo = new PageInfo(webInfoList);
        return pageInfo;
    }

    public WebInfo selectById(Integer id) {
        return webInfoMapper.selectByPrimaryKey(id);
    }


    public List<WebInfo> selectWebInfo(Integer excludeId) {
        WebInfoExample webInfoExample = new WebInfoExample();
        WebInfoExample.Criteria criteria = webInfoExample.or();
        if (excludeId != null) {
            criteria.andIdNotEqualTo(excludeId);
        }
        return webInfoMapper.selectByExample(webInfoExample);
    }
}
