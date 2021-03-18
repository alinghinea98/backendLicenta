package com.alinghinea.Server.controller;


import com.alinghinea.Server.dto.UserDto;
import com.alinghinea.Server.service.UserService;
import com.alinghinea.Server.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTransformer userTransformer;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUsers(String username, String password) {
		return userTransformer.toDto(userService.getUsers(username, password));
	}

	@GetMapping(value="/{pin}",produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUserByPin(double enduserPin) {
		return userTransformer.toDto(userService.getUserByPin(enduserPin));
	}
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody UserDto createUser(UserDto user) {
		System.out.println(user);
		return userTransformer.toDto(userService.createUser(userTransformer.toEntity(user))); // valorile vin in alt format la app form url encoded
	}
	
	@PostMapping(value = "/create/caregiver", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto createCareGiver(@Validated UserDto user) {
		return userTransformer.toDto(userService.createCareGiver(userTransformer.toEntity(user)));
	}
	
	@PostMapping(value = "/create/enduser", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public UserDto createEnduser(@Validated UserDto user) {
		return userTransformer.toDto(userService.createEnduser(userTransformer.toEntity(user)));
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUser(@Validated @RequestBody UserDto user) {
		userService.updateUser(userTransformer.toEntity(user));
	}
	
	@DeleteMapping(value = "/{username}/delete")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable String username) {
		userService.deleteUser(username);
	}
	
	@DeleteMapping(value = "/{username}/delete/{role}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUserByRole(@PathVariable String username, @PathVariable String role) {
		userService.deleteUserByRole(username, role);
	}
	
}
