package com.arya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Country {
	@Id
	@Column(name = "country_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	
	@Column(name = "country_name")
	private String countryName;

}
