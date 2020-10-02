package com.arya.admin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.service.AdminService;

@Controller
public class AdminAccountRegister {
	@Autowired
	private AdminService service;

	@RequestMapping(value = { "/", "/addAdmin" })
	public String loadForm(Model model) {
		AdminAccountModel adminModel = new AdminAccountModel();
		model.addAttribute("adminModel", adminModel);
		Map<Integer, String> role = service.getRole();

		model.addAttribute("role", role.values());
		return "addAccount";
	}

	@PostMapping(value = "/saveAccount")
	public String handleSubmittButton(@ModelAttribute("adminModel") AdminAccountModel aam, Model model) {
		boolean saveAdmin = service.saveAdmin(aam);
		if (saveAdmin) {
			if (aam.getId() != null) {
				model.addAttribute("updMsg", "Account is updated");
			} else {
				model.addAttribute("succMsg", "Account is Created please Check your Email and Activate it....");
			}
		} else {
			model.addAttribute("errMsg", "Please Provide Correct Email Id");
		}
		return "addAccount";
	}

	@GetMapping(value = "/viewAccounts")
	public String handleViewContactLink(Model modle) {
		List<AdminAccountModel> allAccounts = service.getAllAccounts();
		modle.addAttribute("accounts", allAccounts);
		return "viewAccounts";
	}

	/*
	 * @GetMapping("/validateEmail")
	 * 
	 * @ResponseBody public String validateEmail(HttpServletRequest req) { String
	 * contactEmail = req.getParameter("email"); String emailStatus =
	 * contactService.findByEmail(contactEmail); return emailStatus; }
	 * 
	 */

}
