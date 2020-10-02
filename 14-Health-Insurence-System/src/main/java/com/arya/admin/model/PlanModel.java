package com.arya.admin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class PlanModel {

	private Integer id;
	private String planName;
	private String descriptions;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date planStartDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date planEndDate;
}
