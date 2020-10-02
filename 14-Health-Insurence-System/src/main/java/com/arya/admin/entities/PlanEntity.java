package com.arya.admin.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Table(name = "Plans")
@Data
public class PlanEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "plan_name")
	private String planName;
	private String descriptions;
	@Column(name = "plan_start_date")
	private Date planStartDate;
	@Column(name = "plan_end_date")
	private Date planEndDate;
}
