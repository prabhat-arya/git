package com.arya.service;

import java.util.List;

import com.arya.model.SsnEnrollmentRequest;

public interface SsaService {
	
	public List<String> getAllStateNames();
	
	public Long ssnEnrollment(SsnEnrollmentRequest req);
	
	public String checkEnrollment(Long ssn, String stateName);

}
