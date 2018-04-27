package com.zryq.cms.admin.entity;

import javax.persistence.*;
import javax.persistence.Column;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/4/27
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
@Table(name = "cms_role_permission_relationship")
public class PermissionRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permission_id")
    private Integer permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
