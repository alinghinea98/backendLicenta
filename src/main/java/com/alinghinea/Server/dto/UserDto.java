package com.alinghinea.Server.dto;

import com.alinghinea.Server.entities.Kit;
import com.alinghinea.Server.transformer.UserTransformer;
import com.alinghinea.Server.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@UserValidation
public class UserDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserTransformer transformer;

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

	@Size(min = 0, max = 64)
	private String enduserPin;
	
	@Size(min = 0, max = 64)
	private String gender;

	private boolean isDeleted;

	@NotNull
	private Kit kit;

	public String getUsername() {
		return username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Kit getKit() {
		return kit;
	}

	public void setKit(Kit kit) {
		if (kit == null) {
			if (this.kit != null) {
				this.kit.setUser(null);
			} else {
				kit.setUser(transformer.toEntity(this));
			}
			this.kit = kit;
		}
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEnduserPin() {
		return enduserPin;
	}

	public void setEnduserPin(String enduserPin) {
		this.enduserPin = enduserPin;
	}
}
