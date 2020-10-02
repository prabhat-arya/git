package com.arya.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.admin.entities.RolesEntity;

public interface RolesRepository extends JpaRepository<RolesEntity, Serializable> {

}
