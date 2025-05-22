package com.thalyshenrique7.rabbitguard.mapper;

import org.springframework.stereotype.Component;

import com.thalyshenrique7.rabbitguard.dto.UserDTO;
import com.thalyshenrique7.rabbitguard.dto.UserDetailDTO;
import com.thalyshenrique7.rabbitguard.entity.User;

@Component
public class UserMapper {

	public User dtoToEntity(UserDTO dto) {

		User entity = new User();
		entity.setId(dto.getId());
		entity.setEmail(dto.getEmail());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setUsername(dto.getUsername());
		entity.setRole(dto.getRole());

		return entity;
	}

	public UserDetailDTO entityToDtoDetail(User entity) {

		UserDetailDTO dto = new UserDetailDTO();
		dto.setEmail(entity.getEmail());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setUsername(entity.getUsername());
		dto.setStatus(entity.getStatus());
		dto.setRole(entity.getRole());

		return dto;
	}
}
