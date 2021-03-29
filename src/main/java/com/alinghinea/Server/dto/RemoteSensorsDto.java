package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.Sensor;
import com.alinghinea.Server.transformer.RemoteSensorsTransformer;

import java.util.ArrayList;
import java.util.List;

public class RemoteSensorsDto extends BaseDto{
    private static final long serialVersionUID = 1L;

    private RemoteSensorsTransformer transformer;

    private List<Sensor> sensors = new ArrayList();

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void addSensor(Sensor sensor) {
        sensors.add(sensor);
        sensor.setRemoteSensors(transformer.toEntity(this));
    }

    public void removeSensor(Sensor sensor) {
        sensors.remove(sensor);
        sensor.setRemoteSensors(null);
    }
}
