package com.hrms.service;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.hrms.entities.DepartmentEntity;
import com.hrms.model.DepartmentModel;
import com.hrms.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceMockTest {

	@Mock
	private DepartmentRepository repo;
	
	@Mock
	private DepartmentEntity entity;

	@InjectMocks
	private DepartmentServiceImpl service;

	@BeforeEach
	public void setUp(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void getAllDepartment() {

		List<DepartmentEntity> list = new ArrayList<DepartmentEntity>();
		DepartmentEntity depOne = new DepartmentEntity();
		depOne.setDepartmentId(1L);
		depOne.setDepartmentName("it");
		depOne.setDiscreptions("dev");
		DepartmentEntity depTwo = new DepartmentEntity();
		depOne.setDepartmentId(1L);
		depOne.setDepartmentName("bit");
		depOne.setDiscreptions("devvv");
		

		list.add(depOne);
		list.add(depTwo);

		when(repo.findAll()).thenReturn(list);

		List<DepartmentModel> departmentList = service.getAllDepartment();

		assertEquals(2, departmentList.size());

	}


	    @Test
	    public void findAll_WhenRecordPresent_ReturnList(){
	    	List<DepartmentModel> list = new ArrayList<DepartmentModel>();
			DepartmentModel depOne = new DepartmentModel(1L, "it", "dev");
			DepartmentModel depTwo = new DepartmentModel(2L, "it", "dev");

			list.add(depOne);
			list.add(depTwo);
	       
	    	when(service.getAllDepartment()).thenReturn(list);

			List<DepartmentEntity> depList = repo.findAll();

	        //Then
	        assertFalse(depList.isEmpty());
	        verify(repo,times(1)).findAll();
	    }
	
	    @Test
	    public void getDepartmentById() {
	        DepartmentEntity entity=new DepartmentEntity();
	        entity.setDepartmentId(1L);
	        entity.setDepartmentName("it");
	        entity.setDiscreptions("dev");
	        
	        when(repo.findById(1L)).thenReturn(Optional.of(entity));
	        DepartmentModel departmentById = service.getDepartmentById(1L);
	        
	        assertEquals("it", departmentById.getDepartmentName());
	    }
	    
	    @Test
	    public void getDepartmentByIdNagativeCase() {
	        
	        when(repo.findById(1L)).thenReturn(Optional.empty());
	        DepartmentModel departmentById = service.getDepartmentById(1L);
	        
	        assertEquals(null, departmentById);
	    }
	    
	    @Test
	    public void getDepartmentByName() {
	        DepartmentEntity entity=new DepartmentEntity();
	        entity.setDepartmentId(1L);
	        entity.setDepartmentName("it");
	        entity.setDiscreptions("dev");
	        
	        when(repo.findByDepartmentName("it")).thenReturn(entity);
	        DepartmentModel departmentById = service.getDepartmentByName("it");
	        
	        assertEquals("it", departmentById.getDepartmentName());
	    }
	    
	    @Test
	    public void getDepartmentByNameNagativeCase() {
	       
	        
	        when(repo.findByDepartmentName("it")).thenReturn(null);
	        DepartmentModel departmentById = service.getDepartmentByName("it");
	        
	        assertEquals(null, departmentById);
	    }
	    
	    @Test
	    public void saveDepatment() {
	    	
	    //	when(repo.save(Mockito.any(DepartmentEntity.class))).thenAnswer(i -> i.getArguments()[0]);
	        
	    	DepartmentEntity entity=new DepartmentEntity();
	    	entity.setDepartmentId(1L);
	    	entity.setDepartmentName("it");
	    	entity.setDiscreptions("dev");
	    	when(repo.save(Mockito.any(DepartmentEntity.class))).thenReturn(entity);
		        
	        DepartmentModel model=new DepartmentModel(1L, "it", "dev");
			
	        boolean save = service.save(model);
	        assertEquals(true, save);
	    }
	    
	    @Test
	    public void updateDepatmentTest() {
	    	
		    	when(repo.findById(1L)).thenReturn(Optional.of(entity));
			        
		        DepartmentModel model=new DepartmentModel(1L, "it", "dev");
				
		        boolean save = service.updateDepartment(model, 1L);
		        assertEquals(true, save);
		    }
	    
	    @Test
	    public void updateDepatmentNagativeTest() {
	    	
		    	when(repo.findById(1L)).thenReturn(Optional.empty());
			        
		        DepartmentModel model=new DepartmentModel(1L, "it", "dev");
				
		        boolean save = service.updateDepartment(model, 1L);
		        assertEquals(false, save);
		    }
	   
}
