package com.zryq.cms.common.enums;

/**
 * Created by 锐 on 2017/11/16.
 */
public enum ColumnStatus {

    Defalut(1, "默认"), TopColumn(1, "顶部导航"), PicColumn(2, "专题专栏"), CommColumn(3, "灵活栏目");



    private int value;
    private String text;

    ColumnStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }



}
