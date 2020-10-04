package com.hrms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.DepartmentEntity;
import com.hrms.model.DepartmentModel;
import com.hrms.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository repo;

	@Override
	public boolean save(DepartmentModel model) {
	
			DepartmentEntity entity = new DepartmentEntity();
			BeanUtils.copyProperties(model, entity);
			return repo.save(entity) != null;
		
	}

	@Override
	public List<DepartmentModel> getAllDepartment() {
	
		List<DepartmentEntity> allDepartment = repo.findAll();
		
		List<DepartmentModel> models = allDepartment.stream().map(entity -> {
			DepartmentModel model = new DepartmentModel();
			BeanUtils.copyProperties(entity, model);
			return model;
		}).collect(Collectors.toList());

		return models;
	}

	@Override
	public DepartmentModel getDepartmentById(Long id) {
		Optional<DepartmentEntity> optionalEntity = repo.findById(id);
		if (optionalEntity.isPresent()) {
			DepartmentEntity departmentEntity = optionalEntity.get();
			DepartmentModel model = new DepartmentModel();
			BeanUtils.copyProperties(departmentEntity, model);
			return model;
		}
		return null;
	}

	@Override
	public DepartmentModel getDepartmentByName(String name) {
		DepartmentEntity findByDepartmentName = repo.findByDepartmentName(name);
		if (findByDepartmentName != null) {
			DepartmentModel model = new DepartmentModel();
			BeanUtils.copyProperties(findByDepartmentName, model);
			return model;
		}
		return null;
	}

	@Override
	public boolean deleteDepartment(Long id) {
		repo.deleteById(id);
		return true;

	}

	@Override
	public boolean updateDepartment(DepartmentModel model, Long id) {

		Optional<DepartmentEntity> findById = repo.findById(id);
		if (findById.isPresent()) {
			DepartmentEntity oldDepartment = findById.get();
			oldDepartment.setDepartmentName(model.getDepartmentName());
			oldDepartment.setDiscreptions(model.getDiscreptions());
			repo.save(oldDepartment);
			return true;
		}
		return false;
	}

}
