package com.zryq.cms.admin.entity;

import javax.persistence.*;
import javax.persistence.Column;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
@Table(name= "cms_metal_detail")
public class MetalDetail {

    @Column(name ="id")
    @Id
    private Integer id;

    @Column(name = "cate_id")
    private Integer cateId;

    @Column(name = "metal_name")
    private String metalName;

    @Column(name = "metal_model")
    private String metalModel;

    @Column(name = "metal_price")
    private Double metalPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    @OrderBy(value = "DESC")
    private Date updateTime;

    @Transient
    private String cateName;

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public String getMetalModel() {
        return metalModel;
    }

    public void setMetalModel(String metalModel) {
        this.metalModel = metalModel;
    }

    public Double getMetalPrice() {
        return metalPrice;
    }

    public void setMetalPrice(Double metalPrice) {
        this.metalPrice = metalPrice;
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
