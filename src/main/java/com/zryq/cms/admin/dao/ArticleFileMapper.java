package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.ArticleFile;
import com.zryq.cms.admin.entity.ArticleFileExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleFileMapper {
    int countByExample(ArticleFileExample example);

    int deleteByExample(ArticleFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleFile record);

    int insertSelective(ArticleFile record);

    List<ArticleFile> selectByExample(ArticleFileExample example);

    ArticleFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleFile record, @Param("example") ArticleFileExample example);

    int updateByExample(@Param("record") ArticleFile record, @Param("example") ArticleFileExample example);

    int updateByPrimaryKeySelective(ArticleFile record);

    int updateByPrimaryKey(ArticleFile record);
}
