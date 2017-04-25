package com.Example1.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Example1.Company.Employee.Employee;
import com.Example1.Company.Employee.EmployeeRepository;
import com.Example1.Company.Role.Role;
import com.Example1.Company.Role.RoleRepository;
import com.Example1.Company.Example1Application;

@SpringBootTest(classes = Example1Application.class)
@WebAppConfiguration
public class ServiceLayerTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	private long id = 1;
	private String firstName = "John";
	private String lastName = "Quest";
	private String emailid = "john.quest@gmail.com";
	private int age = 29;
	private double salary = 2000.0;
	
	@Test(priority=1)
	public void testCreateEmployee() {
		Employee e = new Employee();
		e.setId(id);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setEmail(emailid);
		e.setAge(age);
		e.setSalary(salary);
		
		employeeRepository.save(e);
		
		Assert.assertNotEquals(e, null);
	}
	
	@Test(priority=2, dependsOnMethods={"testCreateEmployee"})
	public void testFetchEmployee(){
		Employee e;
		e = employeeRepository.findById(id);
		Assert.assertEquals(e.getId(), id);
	}
	
	@Test(priority=2, dependsOnMethods={"testCreateEmployee"})
	public void testAddRoleForEmployee(){
		Employee e = employeeRepository.findById(id);
		Role r = new Role("Software Engineer", "Programming");
		e.setRole(r);
		roleRepository.save(r);
		employeeRepository.save(e);
		Assert.assertNotEquals(r, null);
	}
	
	@Test(priority=4, dependsOnMethods={"testCreateEmployee", "testAddRoleForEmployee"})
	public void deleteEmployee(){
		Employee e;
		e = employeeRepository.findById(id);
		employeeRepository.delete(e);
		
		Assert.assertEquals(e.getId(), id);
		e = employeeRepository.findById(id);
		Assert.assertEquals(e, null);
	}
}
