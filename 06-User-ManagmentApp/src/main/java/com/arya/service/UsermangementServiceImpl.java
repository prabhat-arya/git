package com.arya.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arya.entities.City;
import com.arya.entities.Country;
import com.arya.entities.State;
import com.arya.entities.UnlockAccount;
import com.arya.entities.UserAccount;
import com.arya.entities.UserEntity;
import com.arya.repo.CityRepo;
import com.arya.repo.CountryRepo;
import com.arya.repo.StateRepo;
import com.arya.repo.UserRepo;
import com.arya.utils.AppContent;
import com.arya.utils.PasswordGenerator;
import com.arya.utils.UserMailSender;

@Service
public class UsermangementServiceImpl implements UserManagementService {

	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private StateRepo stateRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserMailSender userEmail;
	
	@Override
	public boolean saveUser(UserEntity user) {
		user.setPassword(PasswordGenerator.generateRandomPassword(AppContent.pwd_Lenth));
		user.setStatus(AppContent.lock_sts);
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		UserEntity saveUser = userRepo.save(userEntity);
		if (null!=saveUser) {
			return userEmail.sendMail(saveUser);
		}
		return false;
	}

	@Override
	public Map<Integer, String> getAllCountries() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		List<Country> contries = countryRepo.findAll();
		contries.forEach(country -> {
			map.put(country.getCountryId(), country.getCountryName());
		});
		return map;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		List<State> stateList = stateRepo.findAllBycountryId(countryId);

		stateList.forEach(state -> {
			map.put(state.getStateId(), state.getStateName());
		});
		return map;

	}

	@Override
	public Map<Integer, String> getcityByCountryId(Integer stateId) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		List<City> cityList = cityRepo.findAllBystateId(stateId);

		cityList.forEach(city -> {
			map.put(city.getCityId(), city.getCityName());
		});
		return map;
	}

	@Override
	public String findByEmail(String emailId) {
		UserEntity findByEmail = userRepo.findByEmailId(emailId);
		if (null!=findByEmail) {
			return "Duplicate";
		}else
		return "Unique";
	}
	@Override
	public UserAccount getUserEntityByTempPwdAndEmail(String tempPwd, String email) {
		UserEntity userEntity = userRepo.findByPasswordAndEmailId(tempPwd, email);
		UserAccount account=null;
		if (userEntity!=null) {
			account=new UserAccount();
			BeanUtils.copyProperties(userEntity, account);
		}
		return account;
	} 

	@Override
	public boolean updateUser(UserAccount user) {
		UserEntity entity=new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity saveEntity = userRepo.save(entity);
		return saveEntity!=null;
	}
}
