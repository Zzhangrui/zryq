package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.FlyMessage;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FlyMessageMapper extends Mapper<FlyMessage> {

    List<FlyMessage>  getMessage(@Param("receiveUserId") Integer receiveUserId,@Param("sendUserId") Integer sendUserId, @Param("parentId")Integer parentId, @Param("id")Integer id);
}
