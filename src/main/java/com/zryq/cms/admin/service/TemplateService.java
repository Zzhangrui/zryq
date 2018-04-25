package com.zryq.cms.admin.service;

import com.zryq.cms.admin.dao.TemplateMapper;
import com.zryq.cms.admin.entity.Template;
import com.zryq.cms.admin.entity.TemplateExample;
import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.entity.WebInfoExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zryq.cms.admin.dao.TemplateMapper;
import com.zryq.cms.admin.entity.Template;
import com.zryq.cms.admin.entity.TemplateExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 锐 on 2017/11/1.
 */
@Service
public class TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    public List<Template> selectAll() {
        TemplateExample templateExample = new TemplateExample();
        return templateMapper.selectByExample(templateExample);
    }

    public PageInfo data(Integer pageNum, Integer pageSize, Integer webId) {
        PageHelper.startPage(pageNum, pageSize);

        TemplateExample templateExample = new TemplateExample();
        TemplateExample.Criteria criteria = templateExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        List<Template> templateList = templateMapper.selectByExample(templateExample);
        PageInfo pageInfo = new PageInfo(templateList);

        return pageInfo;

    }

    public Template selectById(Integer id) {
        return templateMapper.selectByPrimaryKey(id);
    }

}
