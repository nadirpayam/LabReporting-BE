package com.labreporting.labreporting.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;

public class UniqueIdentityValidator implements ConstraintValidator<UniqueIdentity, String> {

	private UserRepository userRepository;

	public UniqueIdentityValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public boolean isValid(String identity, ConstraintValidatorContext context) {
		User user = userRepository.findByIdentity(identity);
		if (user != null) {
			return false;
		} else
			return true;
	}

}
