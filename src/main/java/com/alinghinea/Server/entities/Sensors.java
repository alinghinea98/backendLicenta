package com.alinghinea.Server.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sensors")
public class Sensors extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "sensors")
    private Set<Sensor> sensor;
	
	@Column(name="SENSOR_VALUE")
	private String sensorValue;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kit_id")
	private Sensors sensors;
	
	public Sensors() {
	}

	public Sensors(Set<Sensor> sensor, String sensorValue) {
		this.sensor = sensor;
		this.sensorValue = sensorValue;
	}

	public Set<Sensor> getSensor() {
		return sensor;
	}

	public void setSensor(Set<Sensor> sensor) {
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
