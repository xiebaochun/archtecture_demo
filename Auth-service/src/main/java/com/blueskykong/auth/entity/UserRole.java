package com.blueskykong.auth.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRole {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    private UUID userId;

    private UUID roleId;

    private Boolean isDefault = true;

    public static class UserRoleBuilder {

        private UserRole userRole = new UserRole();

        public UserRoleBuilder withUserId(UUID userId) {
            userRole.setUserId(userId);
            return this;
        }

        public UserRoleBuilder withRoleId(UUID roleId) {
            userRole.setRoleId(roleId);
            return this;
        }

        public UserRole build() {
            return userRole;
        }
    }
}
