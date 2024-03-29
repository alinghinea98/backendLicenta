package com.alinghinea.Server.entities;

import javax.persistence.*;

@Entity
@Table(name = "remote")
public class RemoteSensors extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    @Column(name = "sensorTypeOneName",length = 128)
    private String sensorTypeOneName;

    @Column(name = "sensorTypeOneValue",length = 128)
    private String sensorTypeOneValue;

    @Column(name = "sensorTypeTwoName",length = 128)
    private String sensorTypeTwoName;

    @Column(name = "sensorTypeTwoValue",length = 128)
    private String sensorTypeTwoValue;

    @Column(name = "sensorTypeThreeName",length = 128)
    private String sensorTypeThreeName;

    @Column(name = "sensorTypeThreeValue",length = 128)
    private String sensorTypeThreeValue;

    @Column(name = "sensorTypeFourName",length = 128)
    private String sensorTypeFourName;

    @Column(name = "sensorTypeFourValue",length = 128)
    private String sensorTypeFourValue;

    @Column(name = "sensorTypeFiveName",length = 128)
    private String sensorTypeFiveName;

    @Column(name = "sensorTypeFiveValue",length = 128)
    private String sensorTypeFiveValue;

    public RemoteSensors(String sensorTypeOneName, String sensorTypeOneValue, String sensorTypeTwoName, String sensorTypeTwoValue, String sensorTypeThreeName, String sensorTypeThreeValue, String sensorTypeFourName, String sensorTypeFourValue, String sensorTypeFiveName, String sensorTypeFiveValue) {
        this.sensorTypeOneName = sensorTypeOneName;
        this.sensorTypeOneValue = sensorTypeOneValue;
        this.sensorTypeTwoName = sensorTypeTwoName;
        this.sensorTypeTwoValue = sensorTypeTwoValue;
        this.sensorTypeThreeName = sensorTypeThreeName;
        this.sensorTypeThreeValue = sensorTypeThreeValue;
        this.sensorTypeFourName = sensorTypeFourName;
        this.sensorTypeFourValue = sensorTypeFourValue;
        this.sensorTypeFiveName = sensorTypeFiveName;
        this.sensorTypeFiveValue = sensorTypeFiveValue;
    }

    public RemoteSensors() {
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
