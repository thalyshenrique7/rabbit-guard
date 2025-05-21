package com.thalyshenrique7.rabbitguard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thalyshenrique7.rabbitguard.dto.UserDTO;
import com.thalyshenrique7.rabbitguard.entity.User;
import com.thalyshenrique7.rabbitguard.exception.UserException;
import com.thalyshenrique7.rabbitguard.mapper.UserMapper;
import com.thalyshenrique7.rabbitguard.repository.UserRepository;
import com.thalyshenrique7.rabbitguard.validator.UserValidator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserValidator userValidator;

	@Override
	public void saveUser(UserDTO userDTO) {

		User user = this.userMapper.dtoToEntity(userDTO);

		if (user != null)
			this.userValidator.isUserValid(user);

		try {

			this.userRepository.save(user);
		} catch (Exception e) {
			throw new UserException("Occurred an error by try to save user");
		}
	}

}
