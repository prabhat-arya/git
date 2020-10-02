package com.arya.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.arya.service.SsaService;

@RestController
public class SsnValidationRestController {

	@Autowired
	private SsaService service;

	@GetMapping(value = "/validateSsn/{ssn}/{state}")
	public ResponseEntity<String> validate(@PathVariable("ssn") String ssn, @PathVariable("state") String state) {
		ResponseEntity<String> response = null;
		
		String status = service.checkEnrollment(Long.parseLong(ssn), state);
		
		response = new ResponseEntity<String>(status, HttpStatus.OK);
		
		return response;
	}
}
