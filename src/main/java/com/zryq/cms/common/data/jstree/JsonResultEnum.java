package com.zryq.cms.common.data.jstree;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/4/28
 * Time: 13:56
 * To change this template use File | Settings | File Templates.
 */
public enum JsonResultEnum {
    SUCCESS("1000","请求成功"),
    FAIL("1001","请求失败"),
    ERROR_PARAM("1002","参数异常"),
    ILLEGAL_REQUEST("1003","请求异常"),
    EDIT_SUCCESS("1000","编辑成功"),
    EDIT_FALSE("1001","编辑失败")
    ;

    JsonResultEnum(String code, String messgage) {
        this.code = code;
        this.messgage = messgage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessgage() {
        return messgage;
    }

    public void setMessgage(String messgage) {
        this.messgage = messgage;
    }

    private String code;
    private String messgage;


}
