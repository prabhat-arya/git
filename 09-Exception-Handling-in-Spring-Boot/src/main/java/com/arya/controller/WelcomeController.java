package com.arya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("wel", "Welcome to spring boot");
		String s=null;
		s.length();
		return "welcome";
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handelNullPointerException(Model model) {
		model.addAttribute("err", "Some problem occure please try after Sometime..!!");
		return "error";
	}
}
