package com.zryq.cms.common.data;

/**
 * Created by 锐 on 2017/9/21.
 */
public class DBColumn {

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    private String columnName;

    private String columnType;

    private String columnLength;

    private String colunmComment;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnLength() {
        return columnLength;
    }

    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }

    public String getColunmComment() {
        return colunmComment;
    }

    public void setColunmComment(String colunmComment) {
        this.colunmComment = colunmComment;
    }
}
