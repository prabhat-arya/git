package com.arya.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "SSN_MASTER")
@Data
public class SsnMasterEntity {

	@Id
	@GenericGenerator(name = "id_seq", strategy = "com.arya.generator.SsnIdGenerator")
    @GeneratedValue(generator = "id_seq") 
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "FIRST_NAME")
	private String fname;
	@Column(name = "LAST_NAME")
	private String lname;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "STATE_NAME")
	private String stateName;
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	@Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
}
