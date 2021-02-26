package com.blueskykong.auth.entity;

import lombok.Data;

import java.util.UUID;


@Data
public class RolePermission {

    private Long id;

    private UUID roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public UUID getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(UUID permissionId) {
        this.permissionId = permissionId;
    }

    private UUID permissionId;

}
