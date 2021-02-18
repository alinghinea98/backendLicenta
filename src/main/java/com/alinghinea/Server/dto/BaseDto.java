package com.alinghinea.Server.dto;

import java.io.Serializable;

//used as a layer for multiple request to reduce the mount of data sent and for encapsulation

public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
