package com.zryq.cms.common.enums;

/**
 * Created by Gong on 16/9/7.
 */
public enum AuthcodeStatus {
    Normal(1, "正常"), Invalid(0, "失效");
    private int value;
    private String name;

    AuthcodeStatus(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
