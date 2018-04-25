package com.zryq.cms.common.data.jstree;

/**
 * Created by Gong on 2016/5/11.
 */
public class TreeUtil {
    public static String formatParent(int parentId) {
        return parentId == 0 ? "#" : String.valueOf(parentId);
    }
}
