package com.alinghinea.Server.entities;

import javax.persistence.*;

@Entity
@Table(name = "sensors")
public class Sensors extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name="sensor_id", nullable=true)
    private Sensor sensor;
	
	@Column(name="SENSOR_VALUE")
	private String sensorValue;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kit_id")
	private Sensors sensors;
	
	public Sensors() {
	}

	public Sensors(Sensor sensor, String sensorValue) {
		this.sensor = sensor;
		this.sensorValue = sensorValue;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}

	public String getSensorValue() {
		return sensorValue;
	}

	public void setSensorValue(String sensorValue) {
		this.sensorValue = sensorValue;
	}

	public Sensors returnSensors(){
		return this;
	}
}
