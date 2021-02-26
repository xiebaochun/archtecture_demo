package com.blueskykong.auth.entity;

import lombok.Data;

import java.util.UUID;

/**
 * Created by keets on 2017/11/22.
 */
@Data
public class Permission {

    private UUID id;

    private String permission;

    public UUID getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public void setId(UUID randomUUID) {
    }
}
