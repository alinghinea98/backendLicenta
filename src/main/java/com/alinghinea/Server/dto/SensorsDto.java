package com.alinghinea.Server.dto;


import com.alinghinea.Server.entities.Sensor;

import java.util.List;

public class SensorsDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	List<Sensor> sensorList;

	public List<Sensor> getSensorList() {
		return sensorList;
	}

	public void setSensorList(List<Sensor> sensorList) {
		this.sensorList = sensorList;
	}

}
