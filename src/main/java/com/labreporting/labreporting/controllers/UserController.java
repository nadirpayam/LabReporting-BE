package com.labreporting.labreporting.controllers;

import org.slf4j.LoggerFactory;
import org.apache.tomcat.util.buf.UEncoder;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.errors.ApiError;
import com.labreporting.labreporting.repositories.UserRepository;
import com.labreporting.labreporting.responses.GenericResponse;
import com.labreporting.labreporting.services.UserService;
import java.util.*;

import javax.validation.Valid;
import org.springframework.validation.FieldError;

import org.springframework.*;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/api/users")
	public GenericResponse createUser(@Valid @RequestBody User user) {
		userService.createOneUser(user);
		return new GenericResponse("user created");
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiError handleValidationException(MethodArgumentNotValidException exception) {
		ApiError error = new ApiError(400, "Validation Error", "/api/users");
		Map<String, String> validationErrors = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		error.setValidationErrors(validationErrors);
		return error;
	}

}
