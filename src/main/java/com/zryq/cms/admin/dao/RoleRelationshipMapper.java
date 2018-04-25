package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.RoleRelationship;
import com.zryq.cms.admin.entity.RoleRelationshipExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface RoleRelationshipMapper {
    int countByExample(RoleRelationshipExample example);

    int deleteByExample(RoleRelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleRelationship record);

    int insertSelective(RoleRelationship record);

    List<RoleRelationship> selectByExample(RoleRelationshipExample example);

    RoleRelationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RoleRelationship record, @Param("example") RoleRelationshipExample example);

    int updateByExample(@Param("record") RoleRelationship record, @Param("example") RoleRelationshipExample example);

    int updateByPrimaryKeySelective(RoleRelationship record);

    int updateByPrimaryKey(RoleRelationship record);

    int deleteBatchByRoleId(Integer roleId);
}
