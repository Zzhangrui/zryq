package com.zryq.cms.admin.dao;

import com.zryq.cms.admin.entity.FlyMessage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FlyMessageMapper extends Mapper<FlyMessage> {

    List<FlyMessage>  getMessage(Integer receiveUserId);
}
