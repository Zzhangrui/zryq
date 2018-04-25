package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.User;
import com.zryq.cms.admin.entity.UserExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户id批量删除
     *
     * @param userIds
     * @return
     */
    int deleteBatch(@Param("userIds") List<Integer> userIds);

    User getWithRoleListById(@Param("id") Integer userId);
}
