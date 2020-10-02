package com.arya.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arya.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Serializable> {

	UserEntity findByEmailId(String email);
	public UserEntity findByPasswordAndEmailId(String tempPwd, String email);
}
 