package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.User;

import javax.validation.constraints.Size;

public class RemoteSensorsDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    @Size(min = 0, max = 255)
    private String sensorTypeOneName;

    @Size(min = 0, max = 255)
    private String sensorTypeOneValue;

    @Size(min = 0, max = 255)
    private String sensorTypeTwoName;

    @Size(min = 0, max = 255)
    private String sensorTypeTwoValue;

    @Size(min = 0, max = 255)
    private String sensorTypeThreeName;

    @Size(min = 0, max = 255)
    private String sensorTypeThreeValue;

    @Size(min = 0, max = 255)
    private String sensorTypeFourName;

    @Size(min = 0, max = 255)
    private String sensorTypeFourValue;

    @Size(min = 0, max = 255)
    private String sensorTypeFiveName;

    @Size(min = 0, max = 255)
    private String sensorTypeFiveValue;

    @Size(min = 0, max = 255)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSensorTypeOneName() {
        return sensorTypeOneName;
    }

    public void setSensorTypeOneName(String sensorTypeOneName) {
        this.sensorTypeOneName = sensorTypeOneName;
    }

    public String getSensorTypeOneValue() {
        return sensorTypeOneValue;
    }

    public void setSensorTypeOneValue(String sensorTypeOneValue) {
        this.sensorTypeOneValue = sensorTypeOneValue;
    }

    public String getSensorTypeTwoName() {
        return sensorTypeTwoName;
    }

    public void setSensorTypeTwoName(String sensorTypeTwoName) {
        this.sensorTypeTwoName = sensorTypeTwoName;
    }

    public String getSensorTypeTwoValue() {
        return sensorTypeTwoValue;
    }

    public void setSensorTypeTwoValue(String sensorTypeTwoValue) {
        this.sensorTypeTwoValue = sensorTypeTwoValue;
    }

    public String getSensorTypeThreeName() {
        return sensorTypeThreeName;
    }

    public void setSensorTypeThreeName(String sensorTypeThreeName) {
        this.sensorTypeThreeName = sensorTypeThreeName;
    }

    public String getSensorTypeThreeValue() {
        return sensorTypeThreeValue;
    }

    public void setSensorTypeThreeValue(String sensorTypeThreeValue) {
        this.sensorTypeThreeValue = sensorTypeThreeValue;
    }

    public String getSensorTypeFourName() {
        return sensorTypeFourName;
    }

    public void setSensorTypeFourName(String sensorTypeFourName) {
        this.sensorTypeFourName = sensorTypeFourName;
    }

    public String getSensorTypeFourValue() {
        return sensorTypeFourValue;
    }

    public void setSensorTypeFourValue(String sensorTypeFourValue) {
        this.sensorTypeFourValue = sensorTypeFourValue;
    }

    public String getSensorTypeFiveName() {
        return sensorTypeFiveName;
    }

    public void setSensorTypeFiveName(String sensorTypeFiveName) {
        this.sensorTypeFiveName = sensorTypeFiveName;
    }

    public String getSensorTypeFiveValue() {
        return sensorTypeFiveValue;
    }

    public void setSensorTypeFiveValue(String sensorTypeFiveValue) {
        this.sensorTypeFiveValue = sensorTypeFiveValue;
    }
}
