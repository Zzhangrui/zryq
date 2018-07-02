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
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_metal_detail_log")
public class MetalDetailLog {

    @Column(name ="id")
    @Id
    private Integer id;

    @Column(name = "metal_detail_id")
    private Integer metalDetailId;

    @Column(name = "cate_id")
    private Integer cateId;

    @Column(name = "metal_name")
    private String metalName;

    @Column(name = "metal_model")
    private String metalModel;

    @Column(name = "metal_price")
    private Double metalPrice;

    @Column(name = "create_time")
    @OrderBy(value = "DESC")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMetalDetailId() {
        return metalDetailId;
    }

    public void setMetalDetailId(Integer metalDetailId) {
        this.metalDetailId = metalDetailId;
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
