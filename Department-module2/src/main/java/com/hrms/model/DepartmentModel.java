package com.hrms.model;

public class DepartmentModel {
	
	
	private String departmentName;

	private String discreptions;
	
	public DepartmentModel() {
		// TODO Auto-generated constructor stub
	}

	public DepartmentModel(Long id, String departmentName, String discreptions) {
		super();
		
		this.departmentName = departmentName;
		this.discreptions = discreptions;
	}


	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDiscreptions() {
		return discreptions;
	}

	public void setDiscreptions(String discreptions) {
		this.discreptions = discreptions;
	}
	
	
}
