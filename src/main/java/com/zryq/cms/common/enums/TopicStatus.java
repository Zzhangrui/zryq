package com.zryq.cms.common.enums;

/**
 * Created by Gong on 16/7/26.
 */
public enum TopicStatus {

    Close(0, "话题关闭"), Normal(1, "正常"), Deleted(2, "已删除");

    private int value;
    private String text;

    TopicStatus(int value, String text) {
        this.value = value;
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
