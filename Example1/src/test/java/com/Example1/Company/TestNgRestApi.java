package com.Example1.Company;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;

import com.Example1.Company.Employee.Employee;

public class TestNgRestApi {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

//	@Before
//	public void setup() {
//		System.out.println("Running before function");
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
//	}
	
	@Test
	public void testGetSignupForm() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		Employee e = new Employee();
		e.setFirstName("Ron");
		e.setLastName("Weil");
		e.setAge(20);
		e.setSalary(10000);
	    this.mockMvc.perform(post("/createEmployee")
	    		.param("firstName", "Ron")
	    		.param("lastName", "Weil")
	    		.param("age", "20")
	    		.param("salary", "10000"));
	}
}
