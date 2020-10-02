package com.arya.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.entities.SsnMasterEntity;

public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable> {

	public SsnMasterEntity findBySsnAndStateName(Long ssn, String stateName);
}
