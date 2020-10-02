package com.jum.dao;

import java.util.List;

import com.jum.module.StudentEntity;

public interface IDao {
	public String findNameByID(int id);
	
	public List<String> names();
	
	public StudentEntity studentEntity(int id);

}
