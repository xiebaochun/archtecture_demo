package com.blueskykong.auth.entity;

import lombok.Data;

import java.util.UUID;


@Data
public class ClientSecret extends BaseEntity {
    private String clientId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    private String clientSecret;

    public ClientSecretStatus getStatus() {
        return status;
    }

    public void setStatus(ClientSecretStatus status) {
        this.status = status;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    private ClientSecretStatus status;
    private String purpose;
    private UUID tenantId;
    private UUID userId;

    public static class ClientSecretBuilder {

        private ClientSecret client = new ClientSecret();

        public ClientSecretBuilder withClientId(String clientId) {
            client.setClientId(clientId);
            return this;
        }

        public ClientSecretBuilder withClientSecret(String clientSecret) {
            client.setClientSecret(clientSecret);
            return this;
        }

        public ClientSecretBuilder withStatus(ClientSecretStatus status) {
            client.setStatus(status);
            return this;
        }

        public ClientSecretBuilder withTenantId(UUID tenantId) {
            client.setTenantId(tenantId);
            return this;
        }

        public ClientSecretBuilder withPurpose(String purpose) {
            client.setPurpose(purpose);
            return this;
        }

        public ClientSecret build() {
            return client;
        }
    }
}
