package com.labreporting.labreporting.vm;

import java.util.Date;

public class ReportUpdateRequest {

	
	private String diagnosis;
	private String details;
	private Date date;

	

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
