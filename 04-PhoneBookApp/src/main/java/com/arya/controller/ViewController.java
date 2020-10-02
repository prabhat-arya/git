package com.arya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arya.DTOmodel.Contact;
import com.arya.service.ContactService;

@Controller
public class ViewController {
	@Autowired
	ContactService service;

	@RequestMapping(value = "/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		Contact contactById = service.getContactById(contactId);
		model.addAttribute("contact", contactById);
		return "contactInfo";
	}

	@RequestMapping(value = "/deleteContact")
	public String deleteContactById(@RequestParam("cid")Integer cid, Model model) {
		boolean idDelete = service.deleteContact(cid);
		if (idDelete) {
			return "redirect:/viewContacts";
			
		}
		return null;
	}
}
