package com.arya.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arya.entities.StateMasterEntity;

public interface StateMasteRepository extends JpaRepository<StateMasterEntity, Serializable>{


	@Query(value = "select stateName from StateMasterEntity")
	public List<String> findStateNames();
}
