package com.alinghinea.Server.entities;

import javax.persistence.*;

@Entity
@Table(name = "alert")
public class Alert extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    @Column(name = "SENSOR_TYPE")
    private String sensorType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SENSOR_VALUE")
    private String sensorValue;

    @Column(name = "SEEN")
    private boolean seen = false;

    public Alert() {
    }

    public Alert(User user, String sensorType, String description, String sensorValue) {
        this.user = user;
        this.sensorType = sensorType;
        this.description = description;
        this.sensorValue = sensorValue;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

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
