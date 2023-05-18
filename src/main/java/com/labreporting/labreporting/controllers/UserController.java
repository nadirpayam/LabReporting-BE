package com.labreporting.labreporting.controllers;

import org.slf4j.LoggerFactory;
import org.apache.tomcat.util.buf.UEncoder;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;
import com.labreporting.labreporting.responses.GenericResponse;
import com.labreporting.labreporting.services.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/api/users")
	public GenericResponse createUser(@RequestBody User user) {
		userService.createOneUser(user);
		GenericResponse response = new GenericResponse("Başarılı bir şekilde eklendi");
		return response;
	}
}
