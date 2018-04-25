package com.zryq.cms.common.data;

import java.util.List;

/**
 * Created by 锐 on 2017/9/21.
 */
public class DBTable {

    private String tableName;

    private List<DBColumn> dbColumnList;

    public List<DBColumn> getDbColumnList() {
        return dbColumnList;
    }

    public void setDbColumnList(List<DBColumn> dbColumnList) {
        this.dbColumnList = dbColumnList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
