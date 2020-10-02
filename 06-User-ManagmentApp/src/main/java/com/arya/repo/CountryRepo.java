package com.arya.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arya.entities.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Serializable>{

}
