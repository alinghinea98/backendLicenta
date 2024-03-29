package com.alinghinea.Server.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "utilizatori")
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "USERNAME", nullable = false, length = 64, unique = true)
	@Length(min = 0, max = 64)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false, length = 255)
	@Length(min = 0, max = 255)
	private String password;
	
	@Column(name = "FIRST_NAME", nullable = true, length = 64)
	@Length(min = 0, max = 64)
	private String firstName;
	
	@Column(name = "LAST_NAME", nullable = true, length = 64)
	@Length(min = 0, max = 64)
	private String lastName;
	
	@Column(name = "EMAIL", nullable = false, length = 64)
	@Length(min = 0, max = 64)
	private String email;
	
	@Column(name = "PHONE", nullable = false, length = 64)
	@Length(min = 0, max = 32)
	private String phone;

	@Column(name = "GENDER", nullable = true, length = 64)
	@Length(min = 0, max = 32)
	private String gender;
	
	@Column(name = "ROLE", nullable = false)
	private String userType;
	
	@Column(name = "IS_DELETED", nullable = true)
	private int isDeleted;

	@Column(name = "ENDUSER_PIN")
	private String enduserPin;

	@OneToMany(mappedBy="user")
	private Set<Alert> alerts;

	//works like below
//	@OneToOne(mappedBy = "user")
//	private Kit kit;

//	@OneToOne(fetch =  FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "user", optional = true)
//	private Kit kit;

	@OneToMany(mappedBy = "user")
	private Set<RemoteSensors> remoteSensors;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int isDeleted() {
		return isDeleted;
	}

	public void setDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

//	public Kit getKit() {
//		return kit;
//	}
//
//	public void setKit(Kit kit) {
//		this.kit = kit.returnKit();
//	}
	public String getEnduserPin() {
		return enduserPin;
	}

	public void setEnduserPin(String enduserPin) {
		this.enduserPin = enduserPin;
	}

}
