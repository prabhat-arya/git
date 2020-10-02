package com.arya.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SsnEnrollmentRequest {

	private String fname;
	private String lname;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dob;
	private String gender;
	private String stateName;

}
