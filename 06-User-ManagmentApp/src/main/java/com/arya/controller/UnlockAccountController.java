package com.arya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.entities.UnlockAccount;
import com.arya.entities.UserAccount;
import com.arya.service.UserManagementService;

@Controller
public class UnlockAccountController {
	@Autowired
	UserManagementService service;

	@GetMapping("/unlockAcc")
	public String unlockAccount(@RequestParam("email")String email,Model model){
		model.addAttribute("email",email);
		UnlockAccount uac=new UnlockAccount();
		uac.setEmail(email);
		model.addAttribute("unlockAcc", uac);
		
		return "unlockAccForm";
	}
	
	@PostMapping("/unlockUserAcc")
	public String unlockUserAccount(@ModelAttribute("unlockAcc") UnlockAccount account, Model model){
		UserAccount account2=service.getUserEntityByTempPwdAndEmail(account.getTempPwd(), account.getEmail());
		if (account2 !=null) {
			account2.setStatus("UN-LOCK");
			account2.setPassword(account.getNewPwd());
			boolean isUpdate = service.updateUser(account2);
			if (isUpdate) {
				return "unlockAccSuccess";
   			}
		}
			model.addAttribute("errMsg", "please enter correct passord");
			return "unlockAccForm";
		
	}
}
