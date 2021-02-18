package com.alinghinea.Server.service;

//import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.alinghinea.Server.entities.Type;
import com.alinghinea.Server.entities.User;
import com.alinghinea.Server.repository.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("The username does not exist!"));

		return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
				.password(user.getPassword()).authorities(String.format("Role_%s", user.getUserType().toString()))
				.build();
	}
	
	public User getUsers(String username, String password) {
		return userRepository.getByUsernameAndPassword(username, password);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User createUser(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setPassword(user.getPassword());
		user.setUserType("Admin");
		return saveUser(user);
	}
	
	public User createCareGiver(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setUserType("Caregiver");
		return saveUser(user);
	}
	
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public void updateUser(User user) {
		String password = user.getPassword();
		String savedPassword = userRepository.getById(user.getId()).getPassword();
		if (!password.equals(savedPassword) && !passwordEncoder.matches(password, savedPassword)) {
			user.setPassword(passwordEncoder.encode(password));
		}
		saveUser(user);
	}
	
	@PostConstruct
	private void createAdmin() {
		String username = "admin";
		if (!userRepository.existsByUsername(username)) {
			User user = new User();
			user.setUsername(username);
			user.setFirstName("Ghinea");
			user.setLastName("Alin");
			user.setPhone("0761781921");
			user.setDeleted(0);
			user.setKitId(1);
			user.setEmail("admin@admin.ro");
			user.setPassword(passwordEncoder.encode("admin"));
			user.setUserType("admin");
			saveUser(user);
		}
	}
	
	@PostConstruct
	private void faraParola() {
		String username = "faraparola";
		if(!userRepository.existsByUsername(username)) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setFirstName("Alin");
			newUser.setLastName("Alin");
			newUser.setPhone("0761781921");
			newUser.setDeleted(0);
			newUser.setKitId(1);
			newUser.setEmail("admin@admin.ro");
			newUser.setPassword("parola");
			newUser.setUserType("admin");
			saveUser(newUser);
		}
	}
	
	@PostConstruct
	public void createCaregiver() {
		String username = "caregiver";
		if(!userRepository.existsByUsername(username)) {
			User user = new User();
			user.setUsername(username);
			user.setFirstName("Alin");
			user.setLastName("Ghinea");
			user.setPhone("0761781921");
			user.setKitId(1);
			user.setEmail("caregiver@email.com");
			user.setPassword(passwordEncoder.encode("caregiver"));
			user.setUserType("Caregiver");
			saveUser(user);
		}
	}


}
