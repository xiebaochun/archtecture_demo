package com.blueskykong.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.UUID;

@JsonPropertyOrder({
        "id",
        "name",
        "description"})
@Data
public class DefaultRole {
    @JsonProperty("id")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    public DefaultRole(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
