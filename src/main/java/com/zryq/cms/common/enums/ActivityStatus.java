package com.zryq.cms.common.enums;

/**
 * 0 未发布（草稿）
 * 1 征稿阶段
 * 2 评审阶段
 * 4 活动结束
 * 3 删除
 * 5 关闭不可见
 * Created by Gong on 16/7/26.
 */
public enum ActivityStatus {

    Draft(0, "草稿"), Beginning(1, "征稿中"), InReviewing(2, "评审中"), Deleted(3, "已删除"), Finished(4, "活动结束"), Closed(5, "已关闭");

    private int value;
    private String text;

    ActivityStatus(int value, String text) {
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
