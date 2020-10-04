package com.hrms.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.model.DepartmentModel;
import com.hrms.service.DepartmentService;

@RestController
public class DepartmentRestController {

	Logger log=LoggerFactory.getLogger(DepartmentRestController.class);
			
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/add-department")
	public ResponseEntity<String> addNewDepartment(@RequestBody DepartmentModel model) {
		boolean created = service.save(model);
		if (created) {
			return new ResponseEntity<String>("Department created successfully", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Department not created", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get-departments")
	public List<DepartmentModel> getDepartmentlist() {
		return service.getAllDepartment();
	}

	@GetMapping("/get-department/{id}")
	public ResponseEntity<DepartmentModel> getDepartmentById(@PathVariable Long id) {

		DepartmentModel departmentById = service.getDepartmentById(id);
		if (departmentById != null) {
			return new ResponseEntity<DepartmentModel>(departmentById, HttpStatus.OK);

		}
		return new ResponseEntity<DepartmentModel>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/get-department-by-name/{name}")
	public ResponseEntity<DepartmentModel> getDepartmentByName(@PathVariable String name) {

		DepartmentModel departmentByName = service.getDepartmentByName(name);
		if (departmentByName != null) {
			return new ResponseEntity<DepartmentModel>(departmentByName, HttpStatus.OK);

		}
		return new ResponseEntity<DepartmentModel>(HttpStatus.NOT_FOUND);

	}

	@PutMapping("/update-department/{id}")
	public ResponseEntity<String> update(@RequestBody DepartmentModel model, @PathVariable Long id) {

		service.updateDepartment(model, id);
		return new ResponseEntity<String>("Department is Updated successfully", HttpStatus.OK);

	}

	@DeleteMapping("/delete-department/{id}")
	public ResponseEntity<String> deleteDepartmentlist(@PathVariable Long id) {

		boolean deleteDepartment = service.deleteDepartment(id);
		if (deleteDepartment) {
			return new ResponseEntity<String>("Department Deleted successfully", HttpStatus.OK);

		}
		return new ResponseEntity<String>("Department is Not Available", HttpStatus.NOT_FOUND);
	}
}
