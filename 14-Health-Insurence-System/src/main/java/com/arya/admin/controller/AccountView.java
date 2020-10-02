package com.arya.admin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.admin.entities.RolesEntity;
import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.service.AdminService;

@Controller
public class AccountView {
	@Autowired
	AdminService service;

	@RequestMapping(value = "/editAccount")
	public String editAccount(@RequestParam("id") Integer id, Model model) {
		AdminAccountModel accountById = service.getAccountById(id);
		Map<Integer, String> role = service.getRole();
		model.addAttribute("role", role.values());
		model.addAttribute("adminModel", accountById);
		return "addAccount";
	}

	@RequestMapping(value = "/deleteAccount")
	public String deleteContactById(@RequestParam("id") Integer id, Model model) {
		boolean idDelete = service.deleteAccount(id);
		
		if (idDelete) {
			return "redirect:/viewAccounts";

		}
		return null;
	}

}
