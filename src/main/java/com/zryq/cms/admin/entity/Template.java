package com.zryq.cms.admin.entity;

public class Template {
    private Integer id;

    private String tempName;

    private Integer tempState;

    private String tempPath;

    private String tempType;

    private Integer webId;

    private String tempDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName == null ? null : tempName.trim();
    }

    public Integer getTempState() {
        return tempState;
    }

    public void setTempState(Integer tempState) {
        this.tempState = tempState;
    }

    public String getTempPath() {
        return tempPath;
    }

    public void setTempPath(String tempPath) {
        this.tempPath = tempPath == null ? null : tempPath.trim();
    }

    public String getTempType() {
        return tempType;
    }

    public void setTempType(String tempType) {
        this.tempType = tempType == null ? null : tempType.trim();
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }

    public String getTempDes() {
        return tempDes;
    }

    public void setTempDes(String tempDes) {
        this.tempDes = tempDes == null ? null : tempDes.trim();
    }
}
