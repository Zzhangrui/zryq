package com.zryq.cms.common.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/8/30
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
public class FlyPostConstant {

    public enum PostStatus {
        Draft(0, "草稿"), Publish(1, "发布"), Cancel(2, "撤稿");

        private int value;
        private String text;

        PostStatus(int value, String text) {
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

    public enum PostTop{
        PutTop(1, "置顶"), NotPutTop(0, "未置顶");

        private int value;
        private String text;

        PostTop(int value, String text) {
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

    public enum PostRecommend{
        Recommended(1, "已加精"), NotRecommended(0, "未加精");

        private int value;
        private String text;

        PostRecommend(int value, String text) {
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

    public enum PostEnd{
        END(1, "已结束"), NOT_END(0, "未结束");

        private int value;
        private String text;

        PostEnd(int value, String text) {
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

    public enum PostCategory{
        ASK(1,"提问"),SHARE(2,"分享"),DISCUSS(3,"讨论"),ADVICE(4,"建议"),NOTICE(5,"公告");


        private int value;
        private String text;

        PostCategory(int value, String text) {
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

        public static String getText(Integer value){
            for (PostCategory cate : PostCategory.values()) {
                if (cate.getValue() == value) {
                    return cate.getText();
                }
            }
            return null;
        }
    }
}
