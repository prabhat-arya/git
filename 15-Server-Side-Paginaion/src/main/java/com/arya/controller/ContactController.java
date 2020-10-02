package com.arya.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arya.DTOmodel.Contact;
import com.arya.entities.ContactEntity;
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
		Integer currPno=1;
		Integer pageSize=2;
		Page<ContactEntity> pageData = contactService.getAllContact(pageSize, currPno-1);
		List<ContactEntity> contactList = pageData.getContent();
		Contact contact=new Contact();
		List<Contact> contactList1=contactList.stream().map(entity ->{
			
		}).collect(Collectors.toList());
		BeanUtils.copyProperties(contactList, contact);
	}
	
	
	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(HttpServletRequest req) {
		String contactEmail = req.getParameter("email");
		String emailStatus = contactService.findByEmail(contactEmail);
		return emailStatus;
	}
	
	
	
	
	
	
	
	
	
	
	
}
