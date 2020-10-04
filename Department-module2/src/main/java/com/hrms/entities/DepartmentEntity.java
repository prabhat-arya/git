package com.hrms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "department")
@Data
public class DepartmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_Id")
	private Long departmentId;
	
	@Column(name = "department_name")
	private String departmentName;
	
	private String discreptions;
	

	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
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
	@Override
	public String toString() {
		return "DepartmentEntity [departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", discreptions=" + discreptions + "]";
	}
	
	
	
	

}
