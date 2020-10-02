package com.arya.service;

import org.springframework.data.domain.Page;

import com.arya.DTOmodel.Contact;
import com.arya.entities.ContactEntity;

public interface ContactService {
	
	boolean saveContact(Contact c);
	Page<ContactEntity> getAllContact(Integer pageSize, Integer pageNo );
	Contact getContactById(Integer id);
	boolean deleteContact(Integer cid);
	String findByEmail(String contactEmail);

}
