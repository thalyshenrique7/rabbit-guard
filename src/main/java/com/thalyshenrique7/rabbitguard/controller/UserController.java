package com.thalyshenrique7.rabbitguard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thalyshenrique7.rabbitguard.dto.UserDTO;
import com.thalyshenrique7.rabbitguard.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/api/user", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody UserDTO dto) {

		this.userService.saveUser(dto);
	}
}
