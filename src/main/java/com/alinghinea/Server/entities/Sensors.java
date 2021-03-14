package com.alinghinea.Server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sensors")
public class Sensors extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;
	
	@Column(name="LIGHT")
	private String light;
	
	@Column(name="LATITUDE")
	private String latitude;
	

	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="PROXIMITY")
	private String proximity;

	public Sensors(User user, String light, String latitude, String longitude, String proximity) {
		super();
		this.user = user;
		this.light = light;
		this.latitude = latitude;
		this.longitude = longitude;
		this.proximity = proximity;
	}
	
	public Sensors() {
	}

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
