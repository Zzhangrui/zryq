package com.zryq.cms.common.utils;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 锐 on 2017/8/16.
 */
public class CheckListUtil {


    public static boolean checkContain(List<String> bigList, List<String> smallList) {

        boolean contain = false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String string : bigList) {
            map.put(string, 1);
        }
        for (String string : smallList) {
            if (map.get(string) != null)   //重复了 value+1  跳出
            {
                map.put(string, 2);

                contain = true;  //表示bigList里包括smallList的一个元素
                continue;
            }

        }
        return contain;
    }



    /**
     * 获取两个List的不同元素
     *
     * @param oldList
     * @param newList
     * @return
     */
    public static Map<String, List<Integer>> getDiffrent(List<Integer> oldList, List<Integer> newList) {
        List<Integer> addList = new ArrayList<Integer>();
        List<Integer> removeList = new ArrayList<Integer>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Integer a : oldList) {
            map.put(String.valueOf(a), 1);
        }
        for (Integer b : newList) {
            if (map.get(String.valueOf(b)) != null)   //重复了 value+1  跳出
            {
                map.put(String.valueOf(b), 2);
                continue;
            }
            addList.add(b);   //不重复、说明old里没有的元素， 添加到需要新增的list中
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                removeList.add(Integer.valueOf(entry.getKey()));   //表示old里有，但是newList里没有的元素，添加到删除的list中
            }
        }
        Map defMap = Maps.newHashMap();
        defMap.put("add", addList);
        defMap.put("remove", removeList);
        return defMap;
    }
}
