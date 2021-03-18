package com.alinghinea.Server.dto;


import com.alinghinea.Server.entities.User;

import javax.validation.constraints.Size;

public class SensorsDto extends BaseDto{

	private static final long serialVersionUID = 1L;
	
	@Size(min = 0, max = 255)
    private User user;

	@Size(min = 0, max = 255)
	private String light;
	
	@Size(min = 0, max = 255)
	private String latitude;
	
	@Size(min = 0, max = 255)
	private String longitude;

	@Size(min = 0, max = 255)
	private String proximity;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLight() {
		return light;
	}

	public void setLight(String light) {
		this.light = light;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getProximity() {
		return proximity;
	}

	public void setProximity(String proximity) {
		this.proximity = proximity;
	}


}
