package com.labreporting.labreporting.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;

@Service
public class UserService {

	private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	public void createOneUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public Page<User> getAllUsers(Pageable page, User user) {
		if(user!=null) {
			return userRepository.findByUsernameNot(user.getUsername(), page);
		}
		return userRepository.findAll(page);
	}

}
