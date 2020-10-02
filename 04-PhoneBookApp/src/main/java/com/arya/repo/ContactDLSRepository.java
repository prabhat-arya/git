package com.arya.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arya.entities.ContactEntity;

@Repository
public interface ContactDLSRepository extends JpaRepository<ContactEntity, Serializable> {

}
