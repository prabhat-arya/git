package com.arya.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.print.attribute.standard.Fidelity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.DTOmodel.Contact;
import com.arya.entities.ContactEntity;
import com.arya.repo.ContactDLSRepository;

@Service
public class ContactServiceImple implements ContactService {

	@Autowired
	private ContactDLSRepository contactRepo;

	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity saveEntity = contactRepo.save(entity);

		return saveEntity.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> entities = contactRepo.findAll();
		List<Contact> contacts = new ArrayList<Contact>();
		/*
		 * //legacy approach for (ContactEntity entity : entities) { Contact contact=new
		 * Contact(); BeanUtils.copyProperties(entities, contact);
		 * contacts.add(contact); } return contacts;
		 */

		// java 8 approach
		List<Contact> allContacts = entities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());

		return allContacts;
	}

	@Override
	public Contact getContactById(Integer id) {
		Optional<ContactEntity> findById = contactRepo.findById(id);
		if (findById.isPresent()) {
			ContactEntity contactEntity=findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(contactEntity, c);
			return c;
		}
		return null;
	}

	@Override
	public boolean updateContact(Contact c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

}
