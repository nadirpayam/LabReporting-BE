package com.labreporting.labreporting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.labreporting.labreporting.entities.User;
import com.labreporting.labreporting.services.UserService;

@SpringBootApplication
public class LabReportingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabReportingApplication.class, args);
	}

	@Bean
	CommandLineRunner createInitialUsers(UserService userService) {
		return (args) -> {
            for(int i=1;i<=25;i++) {
			User user = new User();
			user.setEmail("nadir"+i+"payam@hotmail.com");
			user.setIdentity("1234567891"+i);
			user.setName("Nadir");
			user.setPassword("Aa1");
			user.setRole("PAT");
			user.setSurname("Payam");
			user.setUsername("nadir"+i);
			userService.createOneUser(user);
		} };

	}

}
