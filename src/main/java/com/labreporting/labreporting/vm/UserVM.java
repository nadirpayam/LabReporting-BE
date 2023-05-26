package com.labreporting.labreporting.vm;

import com.labreporting.labreporting.entities.User;

public class UserVM {
	
	private String username;
	private String name;
	private String email;
	private String image;
	
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
	public UserVM(User user) {
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
		this.setName(user.getName());
		this.setImage(user.getImage());
	}

}
