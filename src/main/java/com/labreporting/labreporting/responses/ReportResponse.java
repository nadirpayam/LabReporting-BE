package com.labreporting.labreporting.responses;

import java.util.Date;

import com.labreporting.labreporting.entities.Report;

public class ReportResponse {

	private Long reportId;
	private Long userId;
	private Long labId;
	private String name;
	private String surname;
	private String identity;
	private String diagnosis;
	private String details;
	private Date date;

	public ReportResponse(Report entity) {
		this.reportId = entity.getReportId();
		this.userId = entity.getUser().getUserID();
		this.labId = entity.getUser1().getUserID();
		this.name = entity.getUser().getName();
		this.surname = entity.getUser().getSurname();
		this.identity = entity.getUser().getIdentity();
		this.diagnosis = entity.getDiagnosis();
		this.date = entity.getDate();
	}

	public Long getReportId() {
		return reportId;
	}

	public void setReportId(Long reportId) {
		this.reportId = reportId;
	}

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
