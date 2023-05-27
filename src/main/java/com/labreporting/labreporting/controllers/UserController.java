package com.labreporting.labreporting.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.labreporting.labreporting.annotations.CurrentUser;
import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.errors.ApiError;
import com.labreporting.labreporting.responses.GenericResponse;
import com.labreporting.labreporting.services.UserService;
import com.labreporting.labreporting.vm.UserUpdateVM;
import com.labreporting.labreporting.vm.UserVM;

import java.util.List;
import java.util.function.Function;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public GenericResponse createUser(@Valid @RequestBody User user) {
		userService.createOneUser(user);
		return new GenericResponse("user created");
	}

	@GetMapping
	Page<UserVM> getUsers(Pageable page, @CurrentUser User user) {
		return userService.getAllUsers(page,user).map(UserVM::new);
	}

	 @GetMapping("/{username}")
	 UserVM getOneUser(@PathVariable String username) {
		 User user = userService.getByUsername(username);
		 return new UserVM(user);
	 }
	
	 @PutMapping("/{username}")
	 @PreAuthorize("#username == principal.username")
	 UserVM updateUser(@RequestBody UserUpdateVM updatedUser,@PathVariable String username) {
		 User user = userService.updateUser(username,updatedUser);
		return new UserVM(user);
	 }
	
}
