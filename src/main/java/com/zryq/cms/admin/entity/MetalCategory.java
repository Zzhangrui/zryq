package com.zryq.cms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_metal_category")
public class MetalCategory {

    @Column(name ="id")
    @Id
    private Integer id;

    @Column(name = "cate_name")
    private String cateName;

    @Column(name = "cate_desc")
    private String cateDesc;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    @OrderBy(value = "DESC")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
