package com.labreporting.labreporting.entities;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
       
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;
	
	private String name;
	
	private String surname;
	
	private String identity;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String hospitalNO;
	
	private String role;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
	
	
}
