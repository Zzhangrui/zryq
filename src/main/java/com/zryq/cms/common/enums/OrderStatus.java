package com.zryq.cms.common.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/23
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public enum OrderStatus {
    NORMAL(1,"正常"),INVALID(2,"失效"),BACK(3,"退货");
    private int code;

    private String text;

    OrderStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }
}
