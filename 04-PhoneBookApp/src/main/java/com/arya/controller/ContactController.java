package com.arya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.arya.DTOmodel.Contact;
import com.arya.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping(value = {"/","/addContact"})
	public String loadForm(Model model) {
		Contact c=new Contact();
		model.addAttribute("contact", c);
		
		return "contactInfo";
	}

	@PostMapping(value = "/saveContact")
	public String handleSubmittButton(@ModelAttribute("contact") Contact c, Model model) {
		boolean isSeved = contactService.saveContact(c);
		if (isSeved) {
			if (c.getContactId()!= null) {
				model.addAttribute("updMsg", "Contact Update");
			}else
			model.addAttribute("succMsg", "Contact Saved");
		}else {
			model.addAttribute("errMsg","Contact Not Save" );
		}
		
		return "contactInfo";
		
	}
	
	@GetMapping(value = "/viewContacts")
	public String handleViewContactLink(Model modle) {
		List<Contact> contactList = contactService.getAllContact();
		modle.addAttribute("contacts", contactList);
		return "viewContacts";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
