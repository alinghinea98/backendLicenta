package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.User;

import javax.validation.constraints.Size;

public class KitDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    @Size(min = 0, max = 255)
    private String sensorType1;

    @Size(min = 0, max = 255)
    private String sensorType2;

    @Size(min = 0, max = 255)
    private String sensorType3;

    @Size(min = 0, max = 255)
    private String sensorType4;

    @Size(min = 0, max = 255)
    private User user;


    public String getSensorType1() {
        return sensorType1;
    }

    public void setSensorType1(String sensorType1) {
        this.sensorType1 = sensorType1;
    }

    public String getSensorType2() {
        return sensorType2;
    }

    public void setSensorType2(String sensorType2) {
        this.sensorType2 = sensorType2;
    }

    public String getSensorType3() {
        return sensorType3;
    }

    public void setSensorType3(String sensorType3) {
        this.sensorType3 = sensorType3;
    }

    public String getSensorType4() {
        return sensorType4;
    }

    public void setSensorType4(String sensorType4) {
        this.sensorType4 = sensorType4;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
