package com.alinghinea.Server.dto;


import com.alinghinea.Server.entities.Sensor;

import java.util.Set;

public class SensorsDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	Set<Sensor> sensorList;

	public Set<Sensor> getSensorList() {
		return sensorList;
	}

	public void setSensorList(Set<Sensor> sensorList) {
		this.sensorList = sensorList;
	}

}
