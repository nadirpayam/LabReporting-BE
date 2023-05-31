package com.labreporting.labreporting.vm;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReportCreateVM {

	private Long userId;
	private Long labId;
	private String name;
	private String surname;
	private String identity;
	@NotNull(message = "{lab.constraints.diagnosis.NotNull.message}")
	@Size(min = 5, max = 20, message = "{lab.constraints.diagnosis.Size.message}")
	private String diagnosis;
	@NotNull(message = "{lab.constraints.details.NotNull.message}")
	@Size(min = 10, max = 100, message = "{lab.constraints.details.Size.message}")
	private String details;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLabId() {
		return labId;
	}

	public void setLabId(Long labId) {
		this.labId = labId;
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

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


}
