package com.alinghinea.Server.dto;


import com.alinghinea.Server.entities.Kit;
import com.alinghinea.Server.entities.Sensor;

import java.util.List;

public class SensorsDto extends BaseDto{

	private static final long serialVersionUID = 1L;

	List<Sensor> sensorList;

	private Kit kit;

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		this.kit = kit;
	}

	public List<Sensor> getSensorList() {
		return sensorList;
	}

	public void setSensorList(List<Sensor> sensorList) {
		this.sensorList = sensorList;
	}

}
