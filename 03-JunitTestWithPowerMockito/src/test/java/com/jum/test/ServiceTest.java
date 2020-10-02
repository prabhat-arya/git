package com.jum.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.jum.dao.IDao;
import com.jum.servic.ServiceImpl;

public class ServiceTest {
	private static ServiceImpl service;
	
	@BeforeClass
	public static void init() {
		//create the mock for dao
		IDao mockDao = PowerMockito.mock(IDao.class);
		
		//create the serviceImpl object
		service=new ServiceImpl();
		//set the mock object for the dao 
		service.setDao(mockDao);
	
		// behavior for method_01 of Dao
		when(mockDao.findNameByID(100)).thenReturn("prabhat");
		
	}
	
	@Test
	public void findModifiedNameById_01() {
		String findModifiedNameById = service.findModifiedNameById(100);
		assertNotNull(findModifiedNameById);
	}
	
	//Similarly we can create test class for all the method 

}
