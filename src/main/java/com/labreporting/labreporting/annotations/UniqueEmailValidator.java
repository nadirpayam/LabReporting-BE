package com.labreporting.labreporting.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	private UserRepository userRepository;

	public UniqueEmailValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			return false;
		} else
			return true;
	}
	

}
