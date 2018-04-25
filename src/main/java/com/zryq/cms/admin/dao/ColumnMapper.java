package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.Column;
import com.zryq.cms.admin.entity.ColumnExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnMapper {
    int countByExample(ColumnExample example);

    int deleteByExample(ColumnExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Column record);

    int insertSelective(Column record);

    List<Column> selectByExample(ColumnExample example);

    Column selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByExample(@Param("record") Column record, @Param("example") ColumnExample example);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);

    List<Column> selectColumnArticle(@Param("list") List<Integer> idList, @Param("artState") Integer artState);
}
