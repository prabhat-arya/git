package com.hrms.restController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrms.controller.DepartmentRestController;
import com.hrms.model.DepartmentModel;
import com.hrms.service.DepartmentServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartmentRestController.class)
public class DepartmentRestApiTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	DepartmentServiceImpl service;
 
	@Test
	public void getAllDepartmentTest() throws Exception {

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/get-departments");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();

		int status = response.getStatus();

		assertEquals(200, status);
	}

	@Test
	public void fetchOneDepartmentByIdTest() throws Exception {

		final Long departmentId = 1L;
		final DepartmentModel model = new DepartmentModel(1L, "it", "dev");

		when(service.getDepartmentById(departmentId)).thenReturn(model);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/get-department/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void fetchOneDepartmentByIdNoFoundTest() throws Exception {

		when(service.getDepartmentById(1L)).thenReturn(null);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/get-department/1");
		MvcResult andReturn = mockMvc.perform(getReq).andReturn();
		int status1 = andReturn.getResponse().getStatus();
		assertEquals(404, status1);
	}

	@Test
	public void creatDepartmentTest() throws Exception {

		when(service.save(Mockito.any(DepartmentModel.class))).thenReturn(true);
		
		DepartmentModel model = new DepartmentModel();
		model.setDepartmentName("it");
		model.setDiscreptions("dev");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonModel = mapper.writeValueAsString(model);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.post("/add-department")
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonModel)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

	}
	
	@Test
	public void notCreatDepartmentTest() throws Exception {

		when(service.save(Mockito.any(DepartmentModel.class))).thenReturn(false);
		
		DepartmentModel model = new DepartmentModel();
		model.setDepartmentName("it");
		model.setDiscreptions("dev");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonModel = mapper.writeValueAsString(model);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.post("/add-department")
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonModel)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

	}
	
	@Test
	public void updateDepartmentTest() throws Exception {
		DepartmentModel model = new DepartmentModel(1L,"it", "dev"); 
		ObjectMapper mapper = new ObjectMapper();
		String jsonModel = mapper.writeValueAsString(model);

		when(service.updateDepartment(model,1L)).thenReturn(true);
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.put("/update-department/1")
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonModel)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void deleteDepartmentByIdTest() throws Exception {


		when(service.deleteDepartment(1L)).thenReturn(true);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.delete("/delete-department/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}

	@Test
	public void deleteDepartmentByIdNotFoundTest() throws Exception {


		when(service.deleteDepartment(1L)).thenReturn(false);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.delete("/delete-department/1");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(404, status);
	}
	
	@Test
	public void getDepartmentByNameTest() throws Exception {

		DepartmentModel model = new DepartmentModel(1L, "it", "dev"); 
		when(service.getDepartmentByName("it")).thenReturn(model);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders
				.get("/get-department-by-name/it");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void getDepartmentByNameNotFoundTest() throws Exception {

		when(service.getDepartmentByName("it")).thenReturn(null);

		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders
				.get("/get-department-by-name/it");

		MvcResult result = mockMvc.perform(getReq).andReturn();

		MockHttpServletResponse response = result.getResponse();
		int status = response.getStatus();
		assertEquals(404, status);
	}
	
}
