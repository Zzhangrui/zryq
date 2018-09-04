package com.zryq.cms.admin.entity;

import java.util.Date;
import javax.persistence.*;
import javax.persistence.Column;

@Table(name = "fly_message")
public class FlyMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Integer id;

    /**
     * 发送方userId
     */
    @Column(name = "send_user_id")
    private Integer sendUserId;

    /**
     * 发送发用户名
     */
    @Transient
    private String sendUserName;

    /**
     * 接收方userId
     */
    @Column(name = "receive_user_id")
    private Integer receiveUserId;

    /**
     * 接收方用户名
     */
    @Transient
    private String receiveUserName;

    /**
     * 父留言Id
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 内容
     */
    private String content;

    /**
     * 0:未读 1：已读
     */
    @Column(name = "is_read")
    @OrderBy("ASC")
    private Integer isRead;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取发送方userId
     *
     * @return send_user_id - 发送方userId
     */
    public Integer getSendUserId() {
        return sendUserId;
    }

    /**
     * 设置发送方userId
     *
     * @param sendUserId 发送方userId
     */
    public void setSendUserId(Integer sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * 获取接收方userId
     *
     * @return receive_user_id - 接收方userId
     */
    public Integer getReceiveUserId() {
        return receiveUserId;
    }

    /**
     * 设置接收方userId
     *
     * @param receiveUserId 接收方userId
     */
    public void setReceiveUserId(Integer receiveUserId) {
        this.receiveUserId = receiveUserId;
    }

    /**
     * 获取父留言Id
     *
     * @return parent_id - 父留言Id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父留言Id
     *
     * @param parentId 父留言Id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    /**
     * 获取0:未读 1：已读
     *
     * @return is_read - 0:未读 1：已读
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * 设置0:未读 1：已读
     *
     * @param isRead 0:未读 1：已读
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
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

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getReceiveUserName() {
        return receiveUserName;
    }

    public void setReceiveUserName(String receiveUserName) {
        this.receiveUserName = receiveUserName;
    }
}
