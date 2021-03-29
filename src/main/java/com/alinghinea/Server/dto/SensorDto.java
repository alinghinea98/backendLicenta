package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.User;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

public class SensorDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    @Size(min = 0, max = 255)
    private String name;

    @Size(min = 0, max = 255)
    private String description;

    @Size(min = 0, max = 255)
    private String type;

    @Size(min = 0, max = 255)
    private String value;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    private User user; // maybe put User user

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
