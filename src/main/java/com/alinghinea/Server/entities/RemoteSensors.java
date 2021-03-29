package com.alinghinea.Server.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "remote")
public class RemoteSensors extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remoteSensors", orphanRemoval = true)
    private List<Sensor> sensors = new ArrayList();

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
        sensor.setRemoteSensors(this);
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
        sensor.setRemoteSensors(null);
    }

}
