package com.zryq.cms.admin.service;

import com.alibaba.fastjson.JSON;
import com.zryq.cms.admin.dao.GroupMapper;
import com.zryq.cms.admin.dao.WebInfoMapper;
import com.zryq.cms.admin.entity.*;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zryq.cms.admin.dao.GroupMapper;
import com.zryq.cms.admin.entity.Group;
import com.zryq.cms.admin.entity.GroupExample;
import com.zryq.cms.admin.entity.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 * Created by lenovo on 2017-11-6.
 */
@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private WebInfService webInfService;

    public boolean add(Group group) {
        group.setWebId(SessionPerson.getWebId());
        return groupMapper.insert(group) > 0;

    }

    public boolean updateState(Integer id, Integer state) {
        Group group = new Group();
        group.setId(id);
        return groupMapper.updateByPrimaryKeySelective(group) > 0;
    }

    public boolean modifyById(Group group) {
        return groupMapper.updateByPrimaryKeySelective(group) > 0;
    }

    public PageInfo selectGroupData(Integer pageNum, Integer pageSize, Integer webId, String title, Integer parentId) {
        PageHelper.startPage(pageNum, pageSize);
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.or();
        if (!Strings.isNullOrEmpty(title)) {
            criteria.andGroupNameLike("%" + title + "%");
        }

        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        List<Group> groupList = groupMapper.selectByExample(groupExample);
        PageInfo<Group> pageInfo = new PageInfo<>(groupList);
        return pageInfo;
    }

    public Group selectById(Integer id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    public boolean deleteById(Integer id) {
        List idList = Lists.newArrayList(); //用来存储最终结果
        idList.add(id);
        idList = this.selectIdByParentId(idList, id);
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.or();
        criteria.andIdIn(idList);
        return groupMapper.deleteByExample(groupExample) > 0;
    }

    public List<Integer> selectIdByParentId(List<Integer> idList, Integer id) { //2   //最终要输出的结果

        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.or();
        criteria.andParentIdEqualTo(id);
        List<Group> groupList = groupMapper.selectByExample(groupExample);  //4  5
        List<Integer> tempList = Lists.newArrayList();  // 根据一个id查询的字节下一级id集合
        for (Group group : groupList) {
            tempList.add(group.getId());
        }

        if (tempList != null && !tempList.isEmpty()) {
            idList.addAll(tempList);
            for (Integer a : tempList) {
                this.selectIdByParentId(idList, a);
            }

        }
        return idList;
    }

    public List<Group> findAll() {
        return groupMapper.selectByExample(new GroupExample());
    }


    /**
     * 获取机构树
     *
     * @param webId
     * @return
     */
    public String tree(Integer webId) {

        WebInfo webInfo = webInfService.selectById(webId);
        List<Map<String, Object>> treeNodes = Lists.newArrayList();
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.or();



        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }

        List<Group> groupList = groupMapper.selectByExample(groupExample);

        groupList.forEach(group -> {
            Map map = Maps.newHashMap();
            map.put("id", group.getId());
            map.put("name", group.getGroupName());
            map.put("pId", group.getParentId());
            map.put("open", true);
            treeNodes.add(map);
        });
        Map rootMap = Maps.newHashMap();
        rootMap.put("id", null);
        rootMap.put("name", webInfo.getWebName());
        rootMap.put("open", true);
        rootMap.put("nocheck", true);
        treeNodes.add(rootMap);
        return JSON.toJSONString(treeNodes);
    }


    /**
     * 获取站点下的机构信息
     *
     * @param webId
     * @param exclude 不包括的站点
     * @return
     */
    public List<Group> selectWebGroup(Integer webId, Integer exclude) {
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }

        if (exclude != null) {
            criteria.andIdNotEqualTo(exclude);
        }
        return groupMapper.selectByExample(groupExample);
    }
}
