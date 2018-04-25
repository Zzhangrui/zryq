package com.zryq.cms.common.enums;

/**
 * Created by laijiji on 16/9/27.
 */
public enum AuthcodeAction {
    Register("register"), ResetPassword("resetpassword");
    String value;

    AuthcodeAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
