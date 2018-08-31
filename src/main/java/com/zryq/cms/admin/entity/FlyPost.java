package com.zryq.cms.admin.entity;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;
@Table(name = "fly_post")
public class FlyPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 0:未置顶 1：置顶
     */
    private Integer top;

    /**
     * 0：默认  1：加精
     */
    private Integer excellent;

    /**
     * 创建人id
     */
    @Column(name = "create_user_id")
    private Integer createUserId;

    /**
     * 创建人昵称
     */
    @Column(name = "create_user_name")
    private String createUserName;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 0:未结束 1：已结束
     */
    private Integer end;

    /**
     * 内容
     */
    private String content;

    @Transient
    private String createUserImg;

    public String getCreateUserImg() {
        return createUserImg;
    }

    public void setCreateUserImg(String createUserImg) {
        this.createUserImg = createUserImg;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取分类ID
     *
     * @return category_id - 分类ID
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类ID
     *
     * @param categoryId 分类ID
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取0:未置顶 1：置顶
     *
     * @return top - 0:未置顶 1：置顶
     */
    public Integer getTop() {
        return top;
    }

    /**
     * 设置0:未置顶 1：置顶
     *
     * @param top 0:未置顶 1：置顶
     */
    public void setTop(Integer top) {
        this.top = top;
    }

    /**
     * 获取0：默认  1：加精
     *
     * @return excellent - 0：默认  1：加精
     */
    public Integer getExcellent() {
        return excellent;
    }

    /**
     * 设置0：默认  1：加精
     *
     * @param excellent 0：默认  1：加精
     */
    public void setExcellent(Integer excellent) {
        this.excellent = excellent;
    }

    /**
     * 获取创建人id
     *
     * @return create_user_id - 创建人id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置创建人id
     *
     * @param createUserId 创建人id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取创建人昵称
     *
     * @return create_user_name - 创建人昵称
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * 设置创建人昵称
     *
     * @param createUserName 创建人昵称
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取0:未结束 1：已结束
     *
     * @return end - 0:未结束 1：已结束
     */
    public Integer getEnd() {
        return end;
    }

    /**
     * 设置0:未结束 1：已结束
     *
     * @param end 0:未结束 1：已结束
     */
    public void setEnd(Integer end) {
        this.end = end;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
