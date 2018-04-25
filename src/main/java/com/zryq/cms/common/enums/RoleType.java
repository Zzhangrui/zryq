package com.zryq.cms.common.enums;

/**
 * Created by Gong on 16/7/27.
 */
public enum RoleType {
    SuAdmin(1, "suadmin"), Admin(2, "admin"), User(3, "user");
    private int id;
    private String value;

    RoleType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
