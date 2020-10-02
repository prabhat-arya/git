package com.arya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COUNTRY")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer countryId;
	
	@Column(name = "country_name")
	private String countryName;

}
