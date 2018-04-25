package com.zryq.cms.admin.entity;

public class WebInfo {
    private Integer id;

    private String webName;

    private String webDes;

    private String webState;

    private Integer tempId;

    private String webAddress;

    private String webCode;

    private Integer parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName == null ? null : webName.trim();
    }

    public String getWebDes() {
        return webDes;
    }

    public void setWebDes(String webDes) {
        this.webDes = webDes == null ? null : webDes.trim();
    }

    public String getWebState() {
        return webState;
    }

    public void setWebState(String webState) {
        this.webState = webState == null ? null : webState.trim();
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress == null ? null : webAddress.trim();
    }

    public String getWebCode() {
        return webCode;
    }

    public void setWebCode(String webCode) {
        this.webCode = webCode == null ? null : webCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
