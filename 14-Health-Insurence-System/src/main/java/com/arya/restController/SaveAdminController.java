package com.arya.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.service.AdminService;

@RestController
public class SaveAdminController {
	
	@Autowired
	private AdminService service;
	
	@PostMapping(value = "/createAdminAccount",consumes = "application/json")
	public ResponseEntity<String> saveAdmin(@RequestBody AdminAccountModel adminModel) {
		ResponseEntity<String> response=null;
		boolean saveAdmin = service.saveAdmin(adminModel);
		if (saveAdmin==true) {
			String body= "Your Account is Created please check your mails and Unlock your account ";
			response=new ResponseEntity<String>(body, HttpStatus.CREATED);
			return response;
		}
		
		return null;
	}

}
