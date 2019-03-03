package com.jlab.customermanagement.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlab.customermanagement.model.Customer;
import com.jlab.customermanagement.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	private final String API_PATH = "/api/v1/customers";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService custService;

	private Customer validCustomer;

	private Customer invalidCustomerNameandAddressMissing;
	

	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException {

		validCustomer = mapper.readValue(ResourceUtils.getFile("src/test/resources/ValidCustomer.json"),
				Customer.class);

		invalidCustomerNameandAddressMissing = mapper
				.readValue(ResourceUtils.getFile("src/test/resources/InvalidCustomerNameandAdressMissing.json"), Customer.class);
		
		
	}

	@Test
	public void createValidCustomer_test() throws Exception {

		// Create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(API_PATH)
				.content(mapper.writeValueAsBytes(validCustomer)).contentType(MediaType.APPLICATION_JSON);

		// Set the new customer Id as 1 so that the location returned in the header
		// contains /api/v1/customers/1

		int newCustomerId = 1;

		validCustomer.setId(newCustomerId);

		when(custService.save(any(Customer.class))).thenReturn(validCustomer);

		// Check the result for status and location header
		ResultActions result = mockMvc.perform(request).andExpect(status().isCreated()).andExpect(
				header().stringValues("Location", hasItems((containsString(API_PATH + "/" + newCustomerId)))));

	}

	@Test
	public void createCustomerNameandAdressMissing_test() throws Exception {
		
		// Create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(API_PATH)
				.content(mapper.writeValueAsBytes(invalidCustomerNameandAddressMissing)).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult response =  mockMvc.perform(request).andExpect(status().isBadRequest()).andReturn();
		
		JSONAssert.assertEquals("{ \"errors\": [ \"address: Invalid Address. Address must contain a residence and a mailing address\"," + 
				" \"fullName: First and last name must not be null and name fields must not be more than 200 characters\"]}", response.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void createCustomerWrongValueForMaritalStatus_test() throws Exception {
		
		// Create request
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(API_PATH)
				.content( mapper.writeValueAsString(validCustomer).replace("Male", "Ma")).contentType(MediaType.APPLICATION_JSON);
		
		MvcResult response =  mockMvc.perform(request).andExpect(status().isBadRequest()).andReturn();
		
	}


}
