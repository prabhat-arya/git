package com.arya.admin.service;

import java.util.List;
import java.util.Map;

import com.arya.admin.model.AdminAccountModel;

public interface AdminService {
	public boolean saveAdmin(AdminAccountModel adminAccount);
	public List<AdminAccountModel> getAllAccounts();
	public AdminAccountModel getAccountById(Integer id);
	boolean deleteAccount(Integer id);
	public Map<Integer, String> getRole();

}
