package com.labreporting.labreporting.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.swing.text.View;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.labreporting.labreporting.annotations.UniqueEmail;
import com.labreporting.labreporting.annotations.UniqueIdentity;
import com.labreporting.labreporting.annotations.UniqueUsername;

@Entity
@Table(name = "userz")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userID;

	@NotNull(message = "{lab.constraints.name.NotNull.message}")
	@Size(min = 3, max = 30, message = "{lab.constraints.name.Size.message}")
	private String name;

	@NotNull(message = "{lab.constraints.surname.NotNull.message}")
	@Size(min = 2, max = 30, message = "{lab.constraints.surname.Size.message}")
	private String surname;

	@NotNull(message = "{lab.constraints.identity.NotNull.message}")
	@Size(min = 11, max = 11, message = "{lab.constraints.identity.Size.message}")
	@UniqueIdentity
	private String identity;

	@NotNull(message = "{lab.constraints.username.NotNull.message}")
	@Size(min = 10, max = 50, message = "{lab.constraints.username.Size.message}")
	@UniqueUsername
	private String username;

	@NotNull(message = "{lab.constraints.email.NotNull.message}")
	@Size(min = 10, max = 50, message = "{lab.constraints.email.Size.message}")
	@UniqueEmail
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{lab.constraints.email.Pattern.message}")
	private String email;

	@NotNull(message = "{lab.constraints.password.NotNull.message}")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{lab.constraints.password.Pattern.message}") // küçük
	private String password;

	private String hospitalNO;
	
	private String role;
	
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("Role_user");
	}

	@Override
	
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
