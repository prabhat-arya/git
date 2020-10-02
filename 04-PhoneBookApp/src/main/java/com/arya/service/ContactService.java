package com.arya.service;

import java.util.List;

import com.arya.DTOmodel.Contact;

public interface ContactService {
	
	boolean saveContact(Contact c);
	List<Contact> getAllContact();
	Contact getContactById(Integer id);
	boolean updateContact(Contact c);
	boolean deleteContact(Integer cid);

}
