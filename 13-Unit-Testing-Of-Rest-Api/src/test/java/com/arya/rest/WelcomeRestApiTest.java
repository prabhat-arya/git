package com.arya.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WelcomRestController.class)
public class WelcomeRestApiTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void welcomeMsgTest() throws Exception {
		MockHttpServletRequestBuilder getReq = MockMvcRequestBuilders.get("/welcom/prabhat");
		
		MvcResult result = mockMvc.perform(getReq).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		System.out.println("Message is :: "+ response.getContentAsString());
		
		int status = response.getStatus();
		
		assertEquals(200, status);
	}

}
