package com.alinghinea.Server.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sensors")
public class Sensors extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@OneToOne(optional = true)
	@JoinColumn(name = "kit_id")
	private Kit kit;

	@OneToMany(mappedBy = "sensors")
	private List<Sensor> sensorSet;

	public Sensors() {
	}

	public Sensors returnSensors() {
		return this;
	}

	public List<Sensor> getSensorSet() {
		return sensorSet;
	}

	public void setSensorSet(List<Sensor> sensorSet) {
		this.sensorSet = sensorSet;
	}

}
