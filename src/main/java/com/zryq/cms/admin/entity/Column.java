package com.zryq.cms.admin.entity;

import java.util.List;

public class Column {
    private Integer id;

    private String coluName;

    private String coluDes;

    private Integer webId;

    private Integer parentId;

    private Integer state;

    private Integer openComment;

    private String position;

    private String coluType;

    private Integer coluLevel;

    private String coluImgPath;

    private String coluImgName;

    private Integer coluDefault;

    private Integer shareIn;

    private Integer shareOut;


    private List<Article> articleList;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColuName() {
        return coluName;
    }

    public void setColuName(String coluName) {
        this.coluName = coluName == null ? null : coluName.trim();
    }

    public String getColuDes() {
        return coluDes;
    }

    public void setColuDes(String coluDes) {
        this.coluDes = coluDes == null ? null : coluDes.trim();
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getOpenComment() {
        return openComment;
    }

    public void setOpenComment(Integer openComment) {
        this.openComment = openComment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getColuType() {
        return coluType;
    }

    public void setColuType(String coluType) {
        this.coluType = coluType == null ? null : coluType.trim();
    }

    public Integer getColuLevel() {
        return coluLevel;
    }

    public void setColuLevel(Integer coluLevel) {
        this.coluLevel = coluLevel;
    }

    public String getColuImgPath() {
        return coluImgPath;
    }

    public void setColuImgPath(String coluImgPath) {
        this.coluImgPath = coluImgPath == null ? null : coluImgPath.trim();
    }

    public String getColuImgName() {
        return coluImgName;
    }

    public void setColuImgName(String coluImgName) {
        this.coluImgName = coluImgName == null ? null : coluImgName.trim();
    }

    public Integer getColuDefault() {
        return coluDefault;
    }

    public void setColuDefault(Integer coluDefault) {
        this.coluDefault = coluDefault;
    }

    public Integer getShareIn() {
        return shareIn;
    }

    public void setShareIn(Integer shareIn) {
        this.shareIn = shareIn;
    }

    public Integer getShareOut() {
        return shareOut;
    }

    public void setShareOut(Integer shareOut) {
        this.shareOut = shareOut;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
