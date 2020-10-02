package com.arya.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.admin.entities.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable> {

}
