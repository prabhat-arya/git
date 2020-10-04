package com.hrms.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.entities.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Serializable> {

	public DepartmentEntity findByDepartmentName(String departmentName);
	
}
