package com.zryq.cms.common.enums;

/**
 * Created by Gong on 16/7/26.
 */
public enum ArticleStatus {
    Draft(0, "草稿"), Pending(1, "待审核"), Reviewed(2, "审核通过"), Rejected(3, "未通过"), Publish(4, "发布"), Cancel(5, "撤稿"), PutTop(1, "置顶"), NotPutTop(0, "未置顶"), Recommended(1, "已推荐"), NotRecommended(0, "未被推荐");

    private int value;
    private String text;

    ArticleStatus(int value, String text) {
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
