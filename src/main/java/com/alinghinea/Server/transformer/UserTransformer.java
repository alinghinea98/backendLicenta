package com.alinghinea.Server.transformer;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alinghinea.Server.dto.UserDto;
import com.alinghinea.Server.entities.User;
import com.alinghinea.Server.repository.UserRepository;

@Component
public class UserTransformer extends AbstractTransformer<User, UserDto>{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto toDto(User user) {
		UserDto dto = new UserDto();
		BeanUtils.copyProperties(user, dto, "password");
		return dto;
	}

	@Override
	public User toEntity(UserDto dto) {
		User user = findOrCreateNew(dto.getId());
		BeanUtils.copyProperties(dto, user, "password");
		if(dto.getPassword() != null) {
			user.setPassword(dto.getPassword());
		}
		
		return user;
	}

	@Override
	protected User findOrCreateNew(Long id) {
		return id == null ? new User() : userRepository.findById(id).orElseGet(() -> new User());
	}

}
