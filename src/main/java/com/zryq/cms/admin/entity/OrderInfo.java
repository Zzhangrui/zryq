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
 * Time: 17:33
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_order_info")
public class OrderInfo {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "metal_id")
    private Integer metalId;

    @Column(name = "metal_name")
    private String metalName;

    @Column(name = "true_price")
    private Double truePrice;

    @Column(name = "total_money")
    private Double totalMoney;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "guest_name")
    private String guestName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    @OrderBy(value = "DESC")
    private Date updateTime;

    @Column(name = "file_url")
    private String fileUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMetalId() {
        return metalId;
    }

    public void setMetalId(Integer metalId) {
        this.metalId = metalId;
    }

    public String getMetalName() {
        return metalName;
    }

    public void setMetalName(String metalName) {
        this.metalName = metalName;
    }

    public Double getTruePrice() {
        return truePrice;
    }

    public void setTruePrice(Double truePrice) {
        this.truePrice = truePrice;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
