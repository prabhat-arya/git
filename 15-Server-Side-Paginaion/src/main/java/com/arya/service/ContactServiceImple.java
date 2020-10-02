package com.arya.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public Page<ContactEntity> getAllContact(Integer pageSize, Integer pageNo) {
		PageRequest page = PageRequest.of(pageNo, pageSize);
		Page<ContactEntity> findAll = contactRepo.findAll(page);
		return findAll;
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
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}
	@Override
	public String findByEmail(String contactEmail) {
		ContactEntity findByEmail = contactRepo.findBycontactEmail(contactEmail);
		if (null!=findByEmail) {
			return "Duplicate";
		}else
		return "Unique";
	}

}
