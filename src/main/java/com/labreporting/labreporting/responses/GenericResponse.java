package com.labreporting.labreporting.responses;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenericResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GenericResponse(String message) {
		this.message = message;
	}

	
	
}
