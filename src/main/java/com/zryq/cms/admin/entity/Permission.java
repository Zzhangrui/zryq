package com.zryq.cms.admin.entity;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/4/27
 * Time: 14:50
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_permission")
public class Permission {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "permission_path")
    private String permissionPath;

    @Column(name = "permission_name")
    private String permissionName;

    @Column(name = "permission_des")
    private String permissionDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionPath() {
        return permissionPath;
    }

    public void setPermissionPath(String permissionPath) {
        this.permissionPath = permissionPath;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionDes() {
        return permissionDes;
    }

    public void setPermissionDes(String permissionDes) {
        this.permissionDes = permissionDes;
    }
}
