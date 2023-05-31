package com.labreporting.labreporting.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.exceptions.NotFoundException;
import com.labreporting.labreporting.repositories.UserRepository;
import com.labreporting.labreporting.vm.UserUpdateVM;

@Service
public class UserService {

	private PasswordEncoder passwordEncoder;

	private UserRepository userRepository;
	
private FileService fileService;
	

	public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, FileService fileService) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
		this.fileService = fileService;
	}

	public void createOneUser(User user) {
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public Page<User> getAllUsers(Pageable page, User user) {
		if (user != null) {
			return userRepository.findByUsernameNot(user.getUsername(), page);
		}
		return userRepository.findAll(page);
	}

	public User getByUsername(String username) {
		User inDB = userRepository.findByUsername(username);
		if (inDB == null) {
			throw new NotFoundException();
		}
		return inDB;
	}

	public User updateUser(String username, UserUpdateVM updatedUser) {
		User inDb = getByUsername(username);
		inDb.setEmail(updatedUser.getEmail());
		if (updatedUser.getImage() != null) {
			String oldImageName = inDb.getImage();
			try {
				String storedFileName = fileService.writeBase64EncodedStringToFile(updatedUser.getImage());
			     inDb.setImage(storedFileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileService.deleteFile(oldImageName);
		}
		return userRepository.save(inDb);

	}

	public User getByUserId(Long userId) {
		User inDB = userRepository.findByUserID(userId);
		if (inDB == null) {
			throw new NotFoundException();
		}
		return inDB;
	}

	
}
