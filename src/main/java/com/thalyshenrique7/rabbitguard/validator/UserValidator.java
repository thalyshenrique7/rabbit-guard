package com.thalyshenrique7.rabbitguard.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thalyshenrique7.rabbitguard.entity.User;
import com.thalyshenrique7.rabbitguard.enums.Role;
import com.thalyshenrique7.rabbitguard.exception.UserException;
import com.thalyshenrique7.rabbitguard.repository.UserRepository;
import com.thalyshenrique7.rabbitguard.utils.StringUtils;

@Component
public class UserValidator {

	private static final int MAX_LENGTH_FIRSTNAME_AND_LASTNAME = 50;
	private static final int MIN_LENGTH_USERNAME = 3;
	private static final int MAX_LENGTH_USERNAME = 20;

	@Autowired
	private UserRepository repository;

	public void isUserValid(User user) {

		isNotUsernameExists(user.getUsername());
		isFirstNameAndLastNameValid(user.getFirstName(), user.getLastName());
		isUsernameValid(user.getUsername());
		isNotEmailExists(user.getEmail());
		isRoleNotNull(user.getRole());
	}

	private void isNotUsernameExists(String username) {

		User user = this.repository.findByUsername(username);

		if (user != null)
			throw new UserException("Username already exists. Please, choose another username.");
	}

	private void isFirstNameAndLastNameValid(String firstName, String lastName) {

		if (StringUtils.isNotBlank(lastName) && firstName.length() > MAX_LENGTH_FIRSTNAME_AND_LASTNAME)
			throw new UserException("First name must've less than 50 characters.");

		if (StringUtils.isNotBlank(lastName) && lastName.length() > MAX_LENGTH_FIRSTNAME_AND_LASTNAME)
			throw new UserException("Last name must've less than 50 characters.");
	}

	private void isUsernameValid(String username) {

		if (StringUtils.isBlank(username))
			throw new UserException("Username must be filled. Please, enter an username.");

		if (StringUtils.isNotBlank(username)
				&& (username.length() < MIN_LENGTH_USERNAME || username.length() > MAX_LENGTH_USERNAME))
			throw new UserException("Username must've between 3 and 20 characters.");
	}

	private void isNotEmailExists(String email) {

		User user = this.repository.findByEmail(email);

		if (user != null)
			throw new UserException("E-mail already exists.");
	}

	private void isRoleNotNull(Role role) {

		if (role == null)
			throw new UserException("Role cannot be null. Please, choose a role.");
	}

}
