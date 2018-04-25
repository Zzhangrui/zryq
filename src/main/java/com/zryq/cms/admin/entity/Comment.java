package com.zryq.cms.admin.entity;

import java.util.Date;

public class Comment {
    private Integer id;

    private String commContent;

    private Integer userId;

    private String userIp;

    private Date commTime;

    private Integer articleId;

    private String articleTitle;

    private Integer commState;

    private Integer webId;

    private Integer coluId;

    private String coluName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent == null ? null : commContent.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Date getCommTime() {
        return commTime;
    }

    public void setCommTime(Date commTime) {
        this.commTime = commTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Integer getCommState() {
        return commState;
    }

    public void setCommState(Integer commState) {
        this.commState = commState;
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public Integer getColuId() {
        return coluId;
    }

    public void setColuId(Integer coluId) {
        this.coluId = coluId;
    }

    public String getColuName() {
        return coluName;
    }

    public void setColuName(String coluName) {
        this.coluName = coluName == null ? null : coluName.trim();
    }
}
