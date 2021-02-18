package com.alinghinea.Server.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.GenerationType;

//cu serializable facem conversia dintr-un obiect intr-un byte stream
//am facut clasa abstracta ca sa fie accesata doar prin extends

@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //incrementeaza singur id-ul si-l pune ca primary key
	@Column(name = "ID", nullable = false)
	protected Long id;

	@Column(name = "CREATED_TIME", insertable = true, updatable = false, nullable = false)
	protected LocalDateTime createdTime;

	@Column(name = "LAST_MODIFIED_TIME", nullable = false)
	protected LocalDateTime lastModifiedTime;
	
	  //arata ca metoda trebuie apelata inainte de a fi inserata in database
	  @PrePersist
	  void prePersist() {
	    this.lastModifiedTime = LocalDateTime.now();
	    this.createdTime = LocalDateTime.now();
	  }

	  //used before update operation
	  @PreUpdate
	  void preUpdate() {
	    this.lastModifiedTime = LocalDateTime.now();
	  }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(LocalDateTime lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

}
