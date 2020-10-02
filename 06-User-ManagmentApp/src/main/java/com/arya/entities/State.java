package com.arya.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class State {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer stateId;
	@Column(name = "state_name")
	private String stateName;
	private Integer countryId;

}
