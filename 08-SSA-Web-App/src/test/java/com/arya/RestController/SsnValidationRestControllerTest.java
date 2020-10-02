package com.arya.RestController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.arya.restController.SsnValidationRestController;
import com.arya.service.SsaService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SsnValidationRestController.class)
public class SsnValidationRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SsaService service;
	
	@Test
	public void validateSsn() throws Exception {
		
		//pass the value for mock object
		when(service.checkEnrollment(101l, "RI")).thenReturn("IN-VALID");
		
		//get the requestMapping object
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/validateSsn/101/RI");
		MvcResult result = mockMvc.perform(getReq).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		//get the content of response
		String contentAsString = response.getContentAsString();
		System.out.println("Response from API :: "+contentAsString);
		
		assertEquals("IN-VALID", contentAsString);
		
	}

	
	
	
	
	
	
	
	
	
}
