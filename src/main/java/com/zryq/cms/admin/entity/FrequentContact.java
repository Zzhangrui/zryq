package com.zryq.cms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/20
 * Time: 17:29
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_frequent_contact")
public class FrequentContact {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "id_no")
    private String idNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
}
