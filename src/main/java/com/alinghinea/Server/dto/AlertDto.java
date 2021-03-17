package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.User;

import javax.validation.constraints.Size;

public class AlertDto extends BaseDto{

    private static final long serialVersionUID = 1L;

    @Size(min = 0, max = 255)
    private User user;

    @Size(min = 0, max = 255)
    private String sensorType;

    @Size(min = 0, max = 512)
    private String description;

    @Size(min = 0, max = 255)
    private String sensorValue;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(String sensorValue) {
        this.sensorValue = sensorValue;
    }
}
