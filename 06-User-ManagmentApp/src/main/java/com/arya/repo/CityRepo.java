package com.arya.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.entities.City;

public interface CityRepo extends JpaRepository<City, Serializable>{

	List<City> findAllBystateId(Integer stateId);

}
