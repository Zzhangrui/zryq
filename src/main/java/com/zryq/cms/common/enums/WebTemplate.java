package com.zryq.cms.common.enums;

/**
 * Created by 锐 on 2017/11/16.
 */
public enum WebTemplate {

    GZS1(1, "贵州省检察院"),

    GYS(2, "贵阳市检察院"),

    ZYS(3, "遵义市检察院"),

    LPSS(4, "六盘水市检察院"),

    ASS(5, "安顺市检察院"),

    BJS(6, "毕节市检察院"),

    TRS(7, "铜仁市检察院"),

    QXNZ(8, "黔西南州检察院"),

    QDNZ(9, "黔东南州检察院"),

    QNZ(10, "黔南州检察院");



    private int value;

    private String name;

    WebTemplate(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
