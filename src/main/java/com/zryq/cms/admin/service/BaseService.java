package com.zryq.cms.admin.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author ZR
 * @date 2018年4月25日
 */
public class BaseService<D extends Mapper<T>, T> {

    @Autowired
    protected D mapper;

    public List<T> selectAll() {
        return mapper.selectAll();
    }


    public void deleteByPrimaryKey(T t) {
        mapper.deleteByPrimaryKey(t);
    }


    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }


    public int batchInsert(List<T> list) {
        return 0;
    }


    public T selectByPrimaryKey(T t) {
        return mapper.selectByPrimaryKey(t);
    }


    public List<T> selectByExample(T t) {
        Example example = new Example(t.getClass());
        example.createCriteria();
        return mapper.selectByExample(example);
    }


    public List<T> select(T t) {
        return mapper.select(t);
    }


    public int updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t);
    }


    public int updateByExampleSelectiveMapper(@Param("record") T record, @Param("example") Object example) {
        return mapper.updateByExampleSelective(record, example);
    }


    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }
}
