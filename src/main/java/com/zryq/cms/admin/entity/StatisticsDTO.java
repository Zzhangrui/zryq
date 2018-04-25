package com.zryq.cms.admin.entity;

import java.util.Date;
import java.util.List;

/**
 * 数据统计数据格式
 * Created by 锐 on 2017/11/24.
 */
public class StatisticsDTO {


    private String webName;

    private String coluName;

    private Integer count;

    private Date startTime;

    private Date endTime;

    private String groupName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private List<Article> articleList;

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getColuName() {
        return coluName;
    }

    public void setColuName(String coluName) {
        this.coluName = coluName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }
}
