package com.jum.servic;

import java.util.List;

import com.jum.CustomeException.ObjectDatanotfoundException;
import com.jum.dao.IDao;
import com.jum.module.StudentEntity;

public class ServiceImpl implements IService {
	private IDao dao;
	

	public void setDao(IDao dao) {
		this.dao = dao;
	}


	public String findModifiedNameById(int id) {
		String name = dao.findNameByID(id);

		String modifiedName = name.toUpperCase();
		
		return modifiedName;
	}

	public List<String> names() {
		List<String> names = dao.names();
		return names;
	}
	
	
	public StudentEntity studentEntity(int id) {
		StudentEntity studentEntity = dao.studentEntity(id);
		if (studentEntity==null) {
			throw new ObjectDatanotfoundException("Student objcect is not available");
			
		}
		return studentEntity;
	}
	
	
	
	
	
	
	
	
	
	
}
