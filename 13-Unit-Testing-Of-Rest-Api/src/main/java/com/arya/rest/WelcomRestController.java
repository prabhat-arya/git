package com.arya.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomRestController {

	@GetMapping(value = "/welcom/{name}")
	public String getWelcomMsg(@PathVariable("name") String name) {
		String msg = name + ", Welcome to RestApi";

		return msg;
	}

}
