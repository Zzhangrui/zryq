package com.zryq.cms.common.data.jstree;

/**
 * Created by Gong on 2016/5/11.
 */
public class TreeBean {
    private String id;
    private String text;
    private String parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
