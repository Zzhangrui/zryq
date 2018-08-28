package com.zryq.cms.common.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/28
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */
public enum FlyUserStatus {
    NORMAL("1","正常"),LOCK("-1","锁定");
    private String code;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    FlyUserStatus(String code, String text) {
        this.code = code;
        this.text = text;
    }
}
