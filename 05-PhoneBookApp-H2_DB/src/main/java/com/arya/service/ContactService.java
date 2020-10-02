package com.arya.service;

import java.util.List;

import com.arya.DTOmodel.Contact;
import com.arya.entities.ContactEntity;

public interface ContactService {
	
	boolean saveContact(Contact c);
	List<Contact> getAllContact();
	Contact getContactById(Integer id);
	boolean deleteContact(Integer cid);
	String findByEmail(String contactEmail);

}
