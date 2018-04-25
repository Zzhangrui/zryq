package com.zryq.cms.common.data;

/**
 * Created by 锐 on 2017/8/23.
 * 上传文件返回实体
 */
public class FileAttr {



    private String code;

    private String msg;

    //文件名称
    private String fileName;


    //文件类型
    private String fileType;


    //保存相对路径  相对应用名
    private String url;


    //文件大小
    private Long fileSize;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
