package com.arya.RestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.arya.model.SsnEnrollmentRequest;
import com.arya.restController.SsnEnrollmentRestController;
import com.arya.service.SsaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnEnrollmentRestController.class)
public class SsnEnrollmentRestControllerTest {

	@MockBean
	private SsaService service;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void enroll() throws Exception {
		when(service.ssnEnrollment(Mockito.any(SsnEnrollmentRequest.class))).thenReturn(1000l);
		
		SsnEnrollmentRequest req=new SsnEnrollmentRequest();
		req.setFname("prabhat");
		req.setLname("Arya");
		req.setGender("m");
		req.setDob(new Date());
		//now convert this object in to json
		ObjectMapper mapper=new ObjectMapper();
		String reqJson = mapper.writeValueAsString(req);
		
		MockHttpServletRequestBuilder postmapping = MockMvcRequestBuilders.post("/ssnEnrollment")
							  .contentType(MediaType.APPLICATION_JSON)
							  .content(reqJson);
		MvcResult result = mockMvc.perform(postmapping).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println("******Response content is :::****** "+response.getContentAsString());
		
		int status = response.getStatus();
		assertEquals(201, status);
	}
}











