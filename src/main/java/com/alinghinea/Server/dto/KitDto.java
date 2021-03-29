package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.Sensors;

public class KitDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    private Sensors sensors;

    public Sensors getSensors() {
        return sensors;
    }

    public void setSensors(Sensors sensors) {
        this.sensors = sensors.returnSensors();
    }

}
