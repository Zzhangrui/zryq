package com.zryq.cms.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Table(name = "cms_article")
public class Article {
    @Id
    @Column(name = "id")
    private Integer id;

    private String artTitle;

    private String artDigest;

    private String artFrom;

    private String artAuthor;

    private Integer webId;

    private Integer cateId;

    private Date createTime;

    private String createUsername;

    private Integer createUserId;

    private Date publishTime;

    private String publishUsername;

    private String publishUserId;

    private Integer artTop;

    private Integer artState;

    private Date showStartTime;

    private Date showEndTime;

    private Integer openCommen;

    private Integer coluId;

    private String coluName;

    private Integer createGroupId;

    private String createGroupName;

    private String artContent;


    /**
     * 文章第一章图片
     */
    private String firstPicPath;


    private List<String> imgPath;


    /**
     * 点赞数量
     */
    private Integer likeCount;

    /**
     * 阅读数量
     */
    private Integer readCount;

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public List<String> getImgPath() {
        return imgPath;
    }

    public void setImgPath(List<String> imgPath) {
        this.imgPath = imgPath;
    }

    public String getFirstPicPath() {
        return firstPicPath;
    }

    public void setFirstPicPath(String firstPicPath) {
        this.firstPicPath = firstPicPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle == null ? null : artTitle.trim();
    }

    public String getArtDigest() {
        return artDigest;
    }

    public void setArtDigest(String artDigest) {
        this.artDigest = artDigest == null ? null : artDigest.trim();
    }

    public String getArtFrom() {
        return artFrom;
    }

    public void setArtFrom(String artFrom) {
        this.artFrom = artFrom == null ? null : artFrom.trim();
    }

    public String getArtAuthor() {
        return artAuthor;
    }

    public void setArtAuthor(String artAuthor) {
        this.artAuthor = artAuthor == null ? null : artAuthor.trim();
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername == null ? null : createUsername.trim();
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishUsername() {
        return publishUsername;
    }

    public void setPublishUsername(String publishUsername) {
        this.publishUsername = publishUsername == null ? null : publishUsername.trim();
    }

    public String getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(String publishUserId) {
        this.publishUserId = publishUserId == null ? null : publishUserId.trim();
    }

    public Integer getArtTop() {
        return artTop;
    }

    public void setArtTop(Integer artTop) {
        this.artTop = artTop;
    }

    public Integer getArtState() {
        return artState;
    }

    public void setArtState(Integer artState) {
        this.artState = artState;
    }

    public Date getShowStartTime() {
        return showStartTime;
    }

    public void setShowStartTime(Date showStartTime) {
        this.showStartTime = showStartTime;
    }

    public Date getShowEndTime() {
        return showEndTime;
    }

    public void setShowEndTime(Date showEndTime) {
        this.showEndTime = showEndTime;
    }

    public Integer getOpenCommen() {
        return openCommen;
    }

    public void setOpenCommen(Integer openCommen) {
        this.openCommen = openCommen;
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

    public Integer getCreateGroupId() {
        return createGroupId;
    }

    public void setCreateGroupId(Integer createGroupId) {
        this.createGroupId = createGroupId;
    }

    public String getCreateGroupName() {
        return createGroupName;
    }

    public void setCreateGroupName(String createGroupName) {
        this.createGroupName = createGroupName == null ? null : createGroupName.trim();
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent == null ? null : artContent.trim();
    }
}
