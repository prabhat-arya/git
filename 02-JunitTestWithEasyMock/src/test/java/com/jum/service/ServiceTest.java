package com.jum.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.jum.CustomeException.ObjectDatanotfoundException;
import com.jum.dao.IDao;
import com.jum.module.StudentEntity;
import com.jum.servic.ServiceImpl;

public class ServiceTest {
	public static ServiceImpl service;

	@BeforeClass
	public static void init() {
		
		
		// create the mock object for dao
		IDao daoProxy = EasyMock.createMock(IDao.class);
		
		// behavior for method_01 of Dao
		EasyMock.expect(daoProxy.findNameByID(100)).andReturn("Prabhat");

		// behavior for method_02 of Dao
		List<String> names=new ArrayList<String>();
		names.add("prabhat");
		names.add("Arya");
		EasyMock.expect(daoProxy.names()).andReturn(names);
		
		// behavior for method_03 of Dao
		StudentEntity studentEntity=new StudentEntity();
		studentEntity.setId(100);
		studentEntity.setName("prabhat");
		EasyMock.expect(daoProxy.studentEntity(100)).andReturn(studentEntity);
		EasyMock.expect(daoProxy.studentEntity(201)).andReturn(null);
		
		
		EasyMock.replay(daoProxy);

		// set the mock object for the dao
		service = new ServiceImpl();
		service.setDao(daoProxy);
	}

	@Test
	public void fidByid_01() {

		String name = service.findModifiedNameById(100);
		assertNotNull(name);
	}
	
	@Test
	public void names_01() {
		List<String> names = service.names();
		assertNotNull(names);
	}
	@Test
	public void sudentEntity_01() {
		StudentEntity studentEntity = service.studentEntity(100);
		assertNotNull(studentEntity);
	}
	
	@Test(expected = ObjectDatanotfoundException.class)
	public void studentEntity_02() {
		service.studentEntity(201);
		
	}
	
	

}
