package com.zryq.cms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/8
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_scroll")
public class ScrollInfo {

    @Column(name ="id")
    @Id
    private Integer id;

    @Column(name ="web_id")
    private Integer webId;

    @Column(name ="scroll_pic_path")
    private String scrollPicPath;

    @Column(name ="scroll_title")
    private String scrollTitle;

    @Column(name ="scroll_desc")
    private String scrollDesc;

    @Column(name ="url")
    private String url;

    @Column(name ="status")
    private String status;

    @Column(name ="create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "location")
    private String location;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public String getScrollPicPath() {
        return scrollPicPath;
    }

    public void setScrollPicPath(String scrollPicPath) {
        this.scrollPicPath = scrollPicPath;
    }

    public String getScrollTitle() {
        return scrollTitle;
    }

    public void setScrollTitle(String scrollTitle) {
        this.scrollTitle = scrollTitle;
    }

    public String getScrollDesc() {
        return scrollDesc;
    }

    public void setScrollDesc(String scrollDesc) {
        this.scrollDesc = scrollDesc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
