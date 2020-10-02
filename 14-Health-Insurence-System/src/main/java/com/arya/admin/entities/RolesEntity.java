package com.arya.admin.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class RolesEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String roleName;
}
