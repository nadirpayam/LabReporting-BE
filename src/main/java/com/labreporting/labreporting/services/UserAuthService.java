package com.labreporting.labreporting.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.repositories.UserRepository;

@Service
public class UserAuthService implements UserDetailsService {

	private UserRepository userRepository;

	public UserAuthService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username);
        if(inDB == null) 
        	throw new UsernameNotFoundException("User not found");
		return inDB;
	}

}
