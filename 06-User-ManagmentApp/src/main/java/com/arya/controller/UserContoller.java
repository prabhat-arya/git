package com.arya.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arya.DTOmodel.Contact;
import com.arya.entities.UnlockAccount;
import com.arya.entities.UserAccount;
import com.arya.entities.UserEntity;
import com.arya.service.UsermangementServiceImpl;

@Controller
public class UserContoller {

	@Autowired
	private UsermangementServiceImpl service;

	@GetMapping(value = { "/", "home" })
	public String loginForm(Model model) {

		UserAccount user=new UserAccount();
		model.addAttribute("userAcc", user);

		return "home";
	}
	

	@GetMapping("/login")
	public String loginAccount(@RequestParam("emailId")String email,@RequestParam("password")String password,Model model){
		UserAccount account2=service.getUserEntityByTempPwdAndEmail(email,password);
		if (account2!=null) {
			return null;
		}
		return "loadForm";
	}
	@GetMapping(value = "loadForm")
	public String loadForm(Model model) {

		UserEntity user = new UserEntity();
		model.addAttribute("user", user);

		Map<Integer, String> allCountries = service.getAllCountries();
		model.addAttribute("country", allCountries);
		return "loadForm";
	}

	@PostMapping(value = "/saveUser")
	public String handleSubmittButton(@ModelAttribute("user") UserEntity user, Model model) {
		service.saveUser(user);
		return "success";

	}

	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStatesByCountryId(@RequestParam("cid") Integer countryId) {
		return service.getStatesByCountryId(countryId);
	}

	@RequestMapping("/getCity")
	@ResponseBody
	public Map<Integer, String> getCityByCountryId(@RequestParam("sid") Integer stateId) {
		return service.getcityByCountryId(stateId);
	}

	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(HttpServletRequest req) {
		String contactEmail = req.getParameter("email");
		String emailStatus = service.findByEmail(contactEmail);
		return emailStatus;
	}

}
