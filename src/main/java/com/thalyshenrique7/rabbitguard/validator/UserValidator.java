package com.thalyshenrique7.rabbitguard.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thalyshenrique7.rabbitguard.entity.User;
import com.thalyshenrique7.rabbitguard.exception.UserException;
import com.thalyshenrique7.rabbitguard.repository.UserRepository;

import ch.qos.logback.core.util.StringUtil;

@Component
public class UserValidator {

	private static final int MAX_LENGTH_FIRSTNAME_AND_LASTNAME = 50;
	private static final int MIN_LENGTH_USERNAME = 3;
	private static final int MAX_LENGTH_USERNAME = 20;

	@Autowired
	private UserRepository repository;

	public void isUserValid(User user) {

		isUserNameExists(user.getUsername());
		isFirstNameAndLastNameValid(user.getFirstName(), user.getLastName());
		isUserNameValid(user.getUsername());
	}

	private void isUserNameExists(String username) {

		User user = this.repository.findByUsername(username);

		if (user != null)
			throw new UserException("Username already exists. Please, choose another username.");
	}

	private void isFirstNameAndLastNameValid(String firstName, String lastName) {

		if (!StringUtil.isNullOrEmpty(lastName) && firstName.length() > MAX_LENGTH_FIRSTNAME_AND_LASTNAME)
			throw new UserException("First name must've less than 50 characters.");

		if (!StringUtil.isNullOrEmpty(lastName) && lastName.length() > MAX_LENGTH_FIRSTNAME_AND_LASTNAME)
			throw new UserException("Last name must've less than 50 characters.");
	}

	private void isUserNameValid(String username) {

		if (StringUtil.isNullOrEmpty(username))
			throw new UserException("Username must've filled. Please, enter an username.");

		if (!StringUtil.isNullOrEmpty(username)
				&& (username.length() < MIN_LENGTH_USERNAME || username.length() > MAX_LENGTH_USERNAME))
			throw new UserException("Username must've between 3 and 20 characters.");
	}

}
