package com.zryq.cms.admin.service;

import com.alibaba.fastjson.JSON;
import com.zryq.cms.admin.dao.ColumnMapper;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.ColumnExample;
import com.zryq.cms.common.enums.ArticleStatus;
import com.zryq.cms.common.utils.SessionPerson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zryq.cms.admin.dao.ColumnMapper;
import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.ColumnExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 锐 on 2017/11/1.
 */
@Service
public class ColumnService {

    @Autowired
    private ColumnMapper columnMapper;

    @Autowired
    private ArticleService articleService;

    public boolean add(Column column) {

        column.setWebId(SessionPerson.getWebId());//关联站点
        column.setColuLevel(2); //表示的是不是顶级栏目   顶级不会有文章内容，
        return columnMapper.insert(column) > 0;
    }

    public boolean modifyById(Column column) {
        return columnMapper.updateByPrimaryKeySelective(column) > 0;
    }

    public PageInfo selectColumnData(Integer pageNum, Integer pageSize, Integer parentId, Integer webId) {
        PageHelper.startPage(pageNum, pageSize);
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        if (null != webId) {
            criteria.andWebIdEqualTo(webId);
        }
        List<Column> columnList = columnMapper.selectByExample(columnExample);
        PageInfo pageInfo = new PageInfo(columnList);
        return pageInfo;
    }


    /**
     * 获取子机构
     *
     * @param parentId
     * @return
     */
    public List<Column> selectByParentId(List<Column> columnList, Integer parentId, Integer webId) {
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        if (null != webId) {
            criteria.andWebIdEqualTo(webId);
        }
        List<Column> tempList = columnMapper.selectByExample(columnExample);

        if (tempList != null && !tempList.isEmpty()) {
            columnList.addAll(tempList);
            for (Column column : tempList) {
                this.selectByParentId(columnList, column.getId(), null);
            }
            /*tempList.forEach(temp->{
                selectByParentId(tempList,temp.getId(),webId);  //递归循环伙子子孙节点
            });*/

        }

        return columnList;
    }


    public List<Integer> selectIdListByParentId(Integer parentId, Integer webId) {
        List<Column> columnList = Lists.newArrayList();//用于递归接收
        List<Integer> idList = Lists.newArrayList();
        columnList = this.selectByParentId(columnList, parentId, webId);
        if (columnList != null && !columnList.isEmpty()) {
            for (Column column : columnList) {
                idList.add(column.getId());
            }

        }
        return idList;
    }

    public Column selectById(Integer id) {
        return columnMapper.selectByPrimaryKey(id);
    }

    public boolean deleteByIds(String ids) {
        List<Integer> idList = new ArrayList<Integer>();
        List<Integer> sonIdList = Lists.newArrayList();
        if (ids != null) {
            for (int i = 0; i < ids.split(",").length; i++) {
                if (ids.split(",")[i] != null && ids.split(",")[i] != "") {
                    int id = Integer.valueOf(ids.split(",")[i]);
                    if (idList != null && !idList.contains(id))
                        idList.add(id);
                }
            }
        }

        if (idList != null && !idList.isEmpty()) {
            for (int i = 0; i < idList.size(); i++) {
                int id = idList.get(i);
                List<Integer> tempList = Lists.newArrayList();
                tempList = this.selectIdListByParentId(id, null);
                if (tempList != null && !tempList.isEmpty()) {
                    sonIdList.addAll(tempList);
                }
            }

        }
        if (sonIdList != null && !sonIdList.isEmpty()) {
            idList.addAll(sonIdList);
        }

        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        criteria.andIdIn(idList);
        columnMapper.deleteByExample(columnExample);

        return true;
    }


    public String tree(Integer webId) {
        List<Map<String, Object>> treeNodes = Lists.newArrayList();
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }

        List<Column> columnList = columnMapper.selectByExample(columnExample);

        columnList.forEach(column -> {
            Map map = Maps.newHashMap();
            map.put("id", column.getId());
            map.put("name", column.getColuName());
            map.put("pId", column.getParentId());
            map.put("open", true);
            treeNodes.add(map);
        });
        Map rootMap = Maps.newHashMap();
        rootMap.put("id", null);
        rootMap.put("name", "所有栏目");
        rootMap.put("open", true);
        rootMap.put("nocheck", true);
        treeNodes.add(rootMap);
        return JSON.toJSONString(treeNodes);
    }


    /**
     * 根据站点id，栏目类型和上级栏目查询栏目集合
     *
     * @param webId
     * @param coluType
     * @param parentId
     * @return
     */
    public List<Column> selectColumnByWebId(Integer webId, String coluType, Integer parentId) {

        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();
        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }

        if (coluType != null) {
            criteria.andColuTypeEqualTo(coluType);
        }

        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }

        return columnMapper.selectByExample(columnExample);
    }

    /**
     * 查询栏目集合下的文章信息
     *
     * @param pageNum
     * @param pageSize
     * @param idList
     * @param artState
     * @return
     */
    public PageInfo selectColumnArticle(Integer pageNum, Integer pageSize, List<Integer> idList, Integer artState) {
        PageHelper.startPage(pageNum, pageSize);
        List<Column> columnList = columnMapper.selectColumnArticle(idList, artState);
        return new PageInfo(columnList);
    }


    /**
     * 根据集合获取文章信息集合
     *
     * @param pageNum
     * @param pageSize
     * @param idList
     * @param artState 见 ArticleStatus
     * @return
     */
    public List<Column> selectColumnArticleList(Integer pageNum, Integer pageSize, List<Integer> idList, Integer artState) {
        PageHelper.startPage(pageNum, pageSize);
        List<Column> columnList = columnMapper.selectColumnArticle(idList, artState);
        return columnList;
    }


    /**
     * 获取站点下默认的二级栏目
     *
     * @param webId
     * @return
     */
    public List<Column> selectDefaultColumn(Integer webId) {
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        criteria.andWebIdEqualTo(webId);

        criteria.andColuDefaultEqualTo(1);

        criteria.andParentIdIsNotNull();

        List<Column> columnList = columnMapper.selectByExample(columnExample);
        return columnList;
    }


    /**
     * 根据条件获取栏目id
     *
     * @param webId
     * @param coluType
     * @return
     */
    public Integer selectColumnTypeId(Integer webId, String coluType) {
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        criteria.andWebIdEqualTo(webId);

        if (coluType != null) {
            criteria.andColuTypeEqualTo(coluType);  //栏目类型 0：顶部导航  1：专题专栏 2：灵活栏目
        }
        return columnMapper.selectByExample(columnExample).get(0).getId();
    }

    /**
     * 根据站点id获取指定类型的栏目下的一级栏目
     *
     * @param webId
     * @param coluType
     * @return
     */
    public List<Column> selectDefaultSonColumn(Integer webId, String coluType, String coluLevel) {

        Integer parentId = this.selectColumnTypeId(webId, coluType);
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        criteria.andWebIdEqualTo(webId);


        if (!Strings.isNullOrEmpty(coluLevel)) {  //栏目登记
            criteria.andColuTypeEqualTo(coluLevel);
        }

        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }

        return columnMapper.selectByExample(columnExample);
    }


    /**
     * 获取后台手动添加的灵活栏目
     *
     * @param webId
     * @return
     */
    public List<Column> selectFlexColumn(Integer pageNum, Integer pageSize, Integer webId, String coluType) {

        Integer parentId = this.selectColumnTypeId(webId, coluType);

        ColumnExample columnExample = new ColumnExample();

        ColumnExample.Criteria criteria = columnExample.or();

        criteria.andColuDefaultIsNull();

        criteria.andColuLevelEqualTo(2);

        criteria.andParentIdEqualTo(parentId);

        List<Column> columnList = columnMapper.selectByExample(columnExample); //查询出来的栏目信息

        List<Integer> columnIdList = Lists.newArrayList();

        columnList.forEach(column -> {
            columnIdList.add(column.getId());
        });

        columnList =
                this.selectColumnArticleList(pageNum, pageSize, columnIdList, ArticleStatus.Publish.getValue());
        return columnList;
    }


    /**
     * 获取指定位置的栏目 和栏目下的文章信息
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @param position
     * @return
     */
    public Column selectArticleByColumnPosition(Integer pageNum, Integer pageSize, Integer webId, String position) {

        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        if (!Strings.isNullOrEmpty(position)) {
            criteria.andPositionEqualTo(position);
        }

        List<Column> columnList = columnMapper.selectByExample(columnExample);

        if (columnList == null || columnList.isEmpty()) {
            return null;
        }
        Column column = columnList.get(0);

        Integer coluId = column.getId();

        PageInfo pageInfo =
                articleService.selectColumnArticle(pageNum, pageSize, coluId, ArticleStatus.Publish.getValue());

        column.setArticleList(pageInfo.getList());
        return column;
    }


    /**
     * 获取站点下的后添加的灵活栏目和信息
     *
     * @param pageNum
     * @param pageSize
     * @param webId
     * @return
     */
    public List<Column> selectOtherColumnArticle(Integer pageNum, Integer pageSize, Integer webId) {
        ColumnExample columnExample = new ColumnExample();
        ColumnExample.Criteria criteria = columnExample.or();

        if (webId != null) {
            criteria.andWebIdEqualTo(webId);
        }
        criteria.andPositionIsNull();
        criteria.andColuDefaultIsNull();
        criteria.andParentIdIsNotNull();
        List<Column> columnList = columnMapper.selectByExample(columnExample);
        List<Integer> coluIdList = Lists.newArrayList();

        if (columnList != null && !columnList.isEmpty()) {
            columnList.forEach(column -> {
                coluIdList.add(column.getId());
            });
        }

        columnList =
                this.selectColumnArticleList(pageNum, pageSize, coluIdList, ArticleStatus.Publish.getValue());//发布的文章

        //columnList = this.selectColumnArticleList(pageNum,pageSize,columnList,)

        return columnList;
    }


    /**
     * 生成模板自带的栏目信息
     *
     * @param webId
     * @return
     */
    public boolean addGzsDefaultColumn(Integer webId) {
        Column column = new Column();
        column.setWebId(webId);
        column.setColuName("顶部导航");
        column.setColuDes("默认顶部导航父级栏目");
        column.setColuDefault(1);
        column.setColuType("1");//1 ：代表顶部导航
        column.setColuLevel(1); //等级1
        columnMapper.insert(column); //插入顶部导航一级栏目

        Column column1 = new Column();
        column1.setParentId(column.getId());
        column1.setColuDes("顶部导航下默认栏目");
        column1.setColuDefault(1);
        column1.setWebId(webId);
        column1.setColuName("系统通知");
        columnMapper.insertSelective(column1);
        column1.setColuName("工作报告");
        columnMapper.insertSelective(column1);
        column1.setColuName("内部刊物");
        columnMapper.insertSelective(column1);
        column1.setColuName("咨询中心");
        columnMapper.insertSelective(column1);
        column1.setColuName("机关管理规定");
        columnMapper.insertSelective(column1);
        column1.setColuName("法规规章");


        Column column2 = new Column();//专题专栏
        column2.setColuName("专题专栏");
        column2.setColuDefault(1);
        column2.setColuType("2");
        column2.setColuLevel(1);
        column2.setWebId(webId);
        columnMapper.insert(column2);


        Column column3 = new Column();//预设栏目
        column3.setColuName("预设栏目");
        column3.setWebId(webId);
        column3.setColuLevel(1);
        column3.setColuType("3");
        column3.setColuDefault(1);
        columnMapper.insert(column3);

        Column column4 = new Column();
        column4.setParentId(column3.getId());
        column4.setColuDefault(1);
        column4.setWebId(webId);
        column4.setColuDes("灵活扩展栏目");

        column4.setColuName("通知公告");
        column4.setPosition("tzgg");
        columnMapper.insertSelective(column4);
        column4.setColuName("综合要闻");
        column4.setPosition("zhyw");
        columnMapper.insertSelective(column4);
        column4.setColuName("各地动态");
        column4.setPosition("gddt");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采1");
        column4.setPosition("jcfc1");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采2");
        column4.setPosition("jcfc2");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采3");
        column4.setPosition("jcfc3");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采4");
        column4.setPosition("jcfc4");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采5");
        column4.setPosition("jcfc5");
        columnMapper.insertSelective(column4);
        column4.setColuName("检查风采6");
        column4.setPosition("jcfc6");
        columnMapper.insertSelective(column4);
        return true;

    }

    public List<Column> selectAll(){
        ColumnExample columnExample = new ColumnExample();
        columnExample.or();
        return columnMapper.selectByExample(columnExample);
    }



}
