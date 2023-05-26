package com.labreporting.labreporting.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.labreporting.labreporting.annotations.CurrentUser;
import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;
import com.labreporting.labreporting.vm.UserVM;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping
	UserVM handleAuthentication(@CurrentUser User user) {
		return new UserVM(user);
	}

}
