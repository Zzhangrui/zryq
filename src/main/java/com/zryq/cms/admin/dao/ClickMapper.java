package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.Click;
import com.zryq.cms.admin.entity.ClickExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ClickMapper {
    int countByExample(ClickExample example);

    int deleteByExample(ClickExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Click record);

    int insertSelective(Click record);

    List<Click> selectByExample(ClickExample example);

    Click selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Click record, @Param("example") ClickExample example);

    int updateByExample(@Param("record") Click record, @Param("example") ClickExample example);

    int updateByPrimaryKeySelective(Click record);

    int updateByPrimaryKey(Click record);
}
