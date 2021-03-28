package com.alinghinea.Server.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sensors")
public class Sensors extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

//	@Column(name="SENSOR")
//	@OneToMany(mappedBy = "sensors")
//	private List<Sensor> sensorList;

//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="kit_id")
//	private Sensors sensors;

//	public Sensors(List<Sensor> sensorList, Sensors sensors) {
//		this.sensorList = sensorList;
////		this.sensors = sensors;
//	}
//
//	public Sensors() {
//	}

//	public List<Sensor> getSensorList() {
//		return sensorList;
//	}
//
//	public void setSensorList(List<Sensor> sensorList) {
//		this.sensorList = sensorList;
//	}


//	public Sensors getSensors() {
//		return sensors;
//	}
//
//	public void setSensors(Sensors sensors) {
//		this.sensors = sensors;
//	}


	@OneToOne(optional = false)
	@JoinColumn(name = "kit_id", referencedColumnName = "sensors_id")
	private Kit kit;

	@OneToMany(mappedBy = "sensors")
	private Set<Sensor> sensorSet;

	public Sensors() {
	}

	public Sensors returnSensors() {
		return this;
	}

	public Set<Sensor> getSensorSet() {
		return sensorSet;
	}

	public void setSensorSet(Set<Sensor> sensorSet) {
		this.sensorSet = sensorSet;
	}

}
