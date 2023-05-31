package com.labreporting.labreporting.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.labreporting.labreporting.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	User findByIdentity(String identity);
	User findByEmail(String email);
	
	Page<User> findByUsernameNot(String username,Pageable page);
	
	User findByUserID(Long userId);
	
	
}
