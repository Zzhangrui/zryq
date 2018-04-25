package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.WebInfo;
import com.zryq.cms.admin.entity.WebInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WebInfoMapper {
    int countByExample(WebInfoExample example);

    int deleteByExample(WebInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WebInfo record);

    int insertSelective(WebInfo record);

    List<WebInfo> selectByExample(WebInfoExample example);

    WebInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WebInfo record, @Param("example") WebInfoExample example);

    int updateByExample(@Param("record") WebInfo record, @Param("example") WebInfoExample example);

    int updateByPrimaryKeySelective(WebInfo record);

    int updateByPrimaryKey(WebInfo record);
}
