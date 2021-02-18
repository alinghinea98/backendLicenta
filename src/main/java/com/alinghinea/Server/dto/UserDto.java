package com.alinghinea.Server.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.alinghinea.Server.validation.UserValidation;

@UserValidation
public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 0, max = 64)
	private String username;

	@NotNull
	@Size(min = 0, max = 64)
	@Email
	private String email;

	@Size(min = 0, max = 255)
	private String password;

	@Size(min = 0, max = 64)
	private String firstName;

	@Size(min = 0, max = 64)
	private String lastName;

	@Size(min = 0, max = 32)
	private String phone;

	@Size(min = 0, max = 32)
	private String userType;

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	private boolean isDeleted;

	@NotNull
	private int kitId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getKitId() {
		return kitId;
	}

	public void setKitId(int kitId) {
		this.kitId = kitId;
	}

}
