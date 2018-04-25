package com.zryq.cms.admin.entity;

public class Group {
    private Integer id;

    private String groupName;

    private String groupCode;

    private Integer parentId;

    private String groupDes;

    private Integer webId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getGroupDes() {
        return groupDes;
    }

    public void setGroupDes(String groupDes) {
        this.groupDes = groupDes == null ? null : groupDes.trim();
    }

    public Integer getWebId() {
        return webId;
    }

    public void setWebId(Integer webId) {
        this.webId = webId;
    }
}
