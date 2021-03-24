package com.alinghinea.Server.entities;

import javax.persistence.*;

@Entity
@Table(name = "kit")
public class Kit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    //works like below
//    @OneToOne(optional = false)
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user; // maybe put User user

    @OneToOne(mappedBy = "kit", cascade = CascadeType.PERSIST)
    private User user;

    @Column(name = "sensor_type_1",length = 128)
    private String sensorType1;

    @Column(name = "sensor_type_2", length = 128)
    private String sensorType2;

    @Column(name = "sensor_type_3", length = 128)
    private String sensorType3;

    @Column(name = "sensor_type_4", length = 128)
    private String sensorType4;

//    @OneToOne(mappedBy = "kit")
//    private Sensor sensor;
//
//    public Sensor getSensor() {
//        return sensor;
//    }
//
//    public void setSensor(Sensor sensor) {
//        this.sensor = sensor;
//    }

    public Kit(User user, String sensorType1, String sensorType2, String sensorType3, String sensorType4) {
//        this.user = user;
        this.sensorType1 = sensorType1;
        this.sensorType2 = sensorType2;
        this.sensorType3 = sensorType3;
        this.sensorType4 = sensorType4;
    }

    public Kit returnKit() {
        return this;
    }
    public Kit() {
    }

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
