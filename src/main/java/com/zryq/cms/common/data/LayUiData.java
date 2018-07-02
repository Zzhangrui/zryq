package com.zryq.cms.common.data;

import java.util.List;

/**
 * Created by 锐 on 2017/8/22.
 */
public class LayUiData<T> {

    private String code;

    private String msg;

    private Integer count;

    private List<T> data;

    public static final String SUEECSS_CODE = "0";

    public  static final String ERROR_CODE = "-1";

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
