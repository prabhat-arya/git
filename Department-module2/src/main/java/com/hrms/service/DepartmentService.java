package com.hrms.service;

import java.util.List;

import com.hrms.entities.DepartmentEntity;
import com.hrms.model.DepartmentModel;

public interface DepartmentService {

	public boolean save(DepartmentModel model);

	public List<DepartmentModel> getAllDepartment();

	public DepartmentModel getDepartmentById(Long id);
	
	public DepartmentModel getDepartmentByName(String name);

	public boolean deleteDepartment(Long id);

	public boolean updateDepartment(DepartmentModel model, Long id);

}
