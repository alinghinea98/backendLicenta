package com.alinghinea.Server.entities;

import javax.persistence.*;

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

	@OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "sensors", optional = true)
	private Kit kit;

	@Column(name="SENSOR")
	private Sensor sensorList;

	public Sensors(Kit kit, Sensor sensorList) {
		this.kit = kit;
		this.sensorList = sensorList;
	}

	public Sensors() {
	}

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	public Sensor getSensorList() {
		return sensorList;
	}

	public void setSensorList(Sensor sensorList) {
		this.sensorList = sensorList;
	}
}
