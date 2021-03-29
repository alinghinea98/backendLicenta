package com.alinghinea.Server.entities;

import javax.persistence.*;
import java.util.List;

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
