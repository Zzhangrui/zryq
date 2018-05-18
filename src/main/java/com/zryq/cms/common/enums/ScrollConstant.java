package com.zryq.cms.common.enums;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/5/9
 * Time: 14:12
 * To change this template use File | Settings | File Templates.
 */
public class ScrollConstant {

    public enum Status{
        OPEN("1","开启"),CLOSE("0","关闭")
        ;
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

        Status(String code, String text) {
            this.code = code;
            this.text = text;
        }
    }

}
