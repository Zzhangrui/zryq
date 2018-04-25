package com.zryq.cms.common.data;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 访问url根据id
 * Created by 锐 on 2017/11/21.
 */
public class WebTempKeyValue {

    public static Map<Integer, String> WebTempMap = Maps.newHashMap();


    static {
        WebTempMap.put(1, "贵州省检察院");
        WebTempMap.put(2, "贵阳市检察院");
        WebTempMap.put(3, "遵义市检察院");
        WebTempMap.put(4, "六盘水市检察院");
        WebTempMap.put(5, "安顺市检察院");
        WebTempMap.put(6, "毕节市检察院");
        WebTempMap.put(7, "铜仁市检察院");
        WebTempMap.put(8, "黔西南州检察院");
        WebTempMap.put(9, "黔东南州检察院");
        WebTempMap.put(10, "黔南州检察院");

    }
}
