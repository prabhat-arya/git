package com.arya.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_caseworkers")
public class AdminAccountEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	protected String name;
	@Column(name = "email_id")
	protected String emailId;
	protected String gender;
	protected String role;
	protected String TempPassword;
}
