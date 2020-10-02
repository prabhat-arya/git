package com.arya.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.entities.SsnMasterEntity;
import com.arya.model.SsnEnrollmentRequest;
import com.arya.repository.SsnMasterRepository;
import com.arya.repository.StateMasteRepository;

@Service
public class SsaServiceImpl implements SsaService {

	@Autowired
	private StateMasteRepository stateRepo;
	@Autowired
	private SsnMasterRepository ssnRepo;

	@Override
	public List<String> getAllStateNames() {
		return stateRepo.findStateNames();

	}

	@Override
	public Long ssnEnrollment(SsnEnrollmentRequest req) {
		SsnMasterEntity entity=new SsnMasterEntity();
		BeanUtils.copyProperties(req, entity);
		SsnMasterEntity savedentity = ssnRepo.save(entity);
		if (savedentity !=null) {
			return savedentity.getSsn();
		}
		return null;
	}

	@Override
	public String checkEnrollment(Long ssn, String stateName) {
		SsnMasterEntity entity = ssnRepo.findBySsnAndStateName(ssn, stateName);
		if (entity !=null) {
			return "VALID";
		}
		return "IN-VALID";
	}

}
