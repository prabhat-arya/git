package com.arya.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.entities.State;

public interface StateRepo extends JpaRepository<State, Serializable> {

	List<State> findAllBycountryId(Integer countryId);

}
