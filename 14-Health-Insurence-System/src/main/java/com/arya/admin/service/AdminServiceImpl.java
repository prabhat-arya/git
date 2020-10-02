package com.arya.admin.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.admin.entities.AdminAccountEntity;
import com.arya.admin.entities.RolesEntity;
import com.arya.admin.model.AdminAccountModel;
import com.arya.admin.repository.AdminAccountRepository;
import com.arya.admin.repository.RolesRepository;
import com.arya.utils.AdminMailSender;
import com.arya.utils.PasswordGenerator;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminAccountRepository adminRepo;

	@Autowired
	private RolesRepository roleRepo;

	@Autowired
	private AdminMailSender mailSender;

	@Override
	public boolean saveAdmin(AdminAccountModel adminAccount) {
		AdminAccountEntity adminEntity = new AdminAccountEntity();
		BeanUtils.copyProperties(adminAccount, adminEntity);
		adminEntity.setTempPassword(PasswordGenerator.generateRandomPassword(10));
		AdminAccountEntity saveAdmin = adminRepo.save(adminEntity);
		if (null != saveAdmin) {
			
			//here i am soping mail sending
			return true;
			//return mailSender.sendMail(saveAdmin);
		}
		return false;
	}

	@Override
	public Map<Integer, String> getRole() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		List<RolesEntity> allRoles = roleRepo.findAll();
		allRoles.forEach(role -> {
			map.put(role.getId(), role.getRoleName());
		});
		return map;
	}

	@Override
	public List<AdminAccountModel> getAllAccounts() {
		List<AdminAccountEntity> accountEntities = adminRepo.findAll();
		
		List<AdminAccountModel> allAccount = accountEntities.stream().map(account -> {
			AdminAccountModel modelaccount=new AdminAccountModel();
			BeanUtils.copyProperties(account, modelaccount);
			return modelaccount;
		}).collect(Collectors.toList());

		return allAccount;
	}
	
	@Override
	public AdminAccountModel getAccountById(Integer id) {
		Optional<AdminAccountEntity> accountEntity = adminRepo.findById(id);

		if (accountEntity.isPresent()) {
			AdminAccountEntity entity=accountEntity.get();
			AdminAccountModel model= new AdminAccountModel();
			BeanUtils.copyProperties(entity, model);
			return model;
		}
		return null;
	}
	@Override
	public boolean deleteAccount(Integer id) {
		adminRepo.deleteById(id);
		return true;
	}
}
