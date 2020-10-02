package com.arya.service;

import java.util.Map;

import com.arya.entities.UserAccount;
import com.arya.entities.UserEntity;

public interface UserManagementService {
	public Map<Integer, String> getAllCountries();
	public Map<Integer, String> getStatesByCountryId(Integer countryId);
	public Map<Integer, String> getcityByCountryId(Integer stateId);
	public boolean saveUser(UserEntity user);
	String findByEmail(String contactEmail);
	UserAccount getUserEntityByTempPwdAndEmail(String tempPwd, String email);
	
	public boolean updateUser(UserAccount user);
}
