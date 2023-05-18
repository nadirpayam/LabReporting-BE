package com.labreporting.labreporting.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	private UserRepository userRepository;

	public UniqueUsernameValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			return false;
		} else
			return true;
	}

}
