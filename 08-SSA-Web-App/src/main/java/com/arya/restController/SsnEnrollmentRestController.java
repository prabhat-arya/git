package com.arya.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arya.model.SsnEnrollmentRequest;
import com.arya.service.SsaService;

@RestController
public class SsnEnrollmentRestController {
	
	@Autowired
	private SsaService service;

	@PostMapping(value = "/ssnEnrollment",
				consumes = "application/json")
	public ResponseEntity<String> enroll(@RequestBody SsnEnrollmentRequest request){
		ResponseEntity<String> response=null;
		 Long ssn = service.ssnEnrollment(request);
		 String body="Your SSN Enrollment is Completed successfully. Your SSN :"+ssn;
		 response=new ResponseEntity<String>(body, HttpStatus.CREATED);
		 
		return response;
	}
}
