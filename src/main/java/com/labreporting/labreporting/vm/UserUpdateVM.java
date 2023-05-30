package com.labreporting.labreporting.vm;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.labreporting.labreporting.annotations.FileType;
import com.labreporting.labreporting.annotations.UniqueEmail;

public class UserUpdateVM {

	@NotNull(message = "{lab.constraints.email.NotNull.message}")
	@Size(min = 10, max = 50, message = "{lab.constraints.email.Size.message}")
	@UniqueEmail
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "{lab.constraints.email.Pattern.message}")
	private String email;
	
	@FileType(types={"jpeg","png"})
	private String image;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
