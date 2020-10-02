package com.jum.servic;

import java.util.List;

import com.jum.module.StudentEntity;

public interface IService {
	public String findModifiedNameById(int id);
	
	public List<String> names();
	
	public StudentEntity studentEntity(int id);

}
