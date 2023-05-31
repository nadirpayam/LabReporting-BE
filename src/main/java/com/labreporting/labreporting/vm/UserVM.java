package com.labreporting.labreporting.vm;

import com.labreporting.labreporting.entities.User;

public class UserVM {

	private String username;
	private String name;
	private String email;
	private String image;
	private String hospitalNO;
	private String role;
	private String surname;
	private String identity;
	private Long userId;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getHospitalNO() {
		return hospitalNO;
	}

	public void setHospitalNO(String hospitalNO) {
		this.hospitalNO = hospitalNO;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UserVM(User user) {
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
		this.setName(user.getName());
		this.setImage(user.getImage());
		this.setHospitalNO(user.getHospitalNO());
		this.setRole(user.getRole());
		this.setSurname(user.getSurname());
		this.setIdentity(user.getIdentity());
		this.setUserId(user.getUserID());
	}

}
