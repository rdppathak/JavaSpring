package com.Example1.Company;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Example1.Company.Employee.Employee;
import com.Example1.Company.Employee.EmployeeRepository;
import com.Example1.Company.Project.Project;
import com.Example1.Company.Project.ProjectRepository;
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
	@Autowired
	private ProjectRepository projectRepository;
	
	
	private long id = 1;
	private String firstName = "John";
	private String lastName = "Quest";
	private String emailid = "john.quest@gmail.com";
	private int age = 29;
	private double salary = 2000.0;
	
	private String projectName = "Engineering";
	private String projectDescription = "MindsphereIOT";
	
	private String roleTitle = "Software Engineer";
	private String roleDescription = "Programming";
	
	
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
		e = employeeRepository.findByEmpId(id);
		Assert.assertEquals(e.getId(), id);
	}
	
	@Test(priority=2, dependsOnMethods={"testCreateEmployee"})
	public void testAddRoleForEmployee(){
		
		Role r = new Role(roleTitle, roleDescription);
		roleRepository.save(r);
		Employee e = employeeRepository.findByEmpId(id);
		e.setRole(r);
		employeeRepository.save(e);
		Assert.assertNotEquals(r, null);
	}
	
	@Test(priority=3, dependsOnMethods={"testCreateEmployee"})
	public void testAddProjectForEmployee(){
		Project p = new Project(projectName, projectDescription);
		projectRepository.save(p);
		Employee e = employeeRepository.findByEmpId(id);
		e.setProject(p);
		employeeRepository.save(e);
	}
	
	@Test(priority=3, dependsOnMethods={"testAddRoleForEmployee"})
	public void testRemoveRoleForEmployee(){
		Employee e = employeeRepository.findByEmpId(id);
		e.removeRole(roleTitle);
		employeeRepository.save(e);
		e = employeeRepository.findByEmpId(id);
	}
	
	@Test(priority=3, dependsOnMethods={"testAddProjectForEmployee"})
	public void testRemoveProjectForEmployee(){
		Employee e = employeeRepository.findByEmpId(id);
		e.removeProject(projectName);
		employeeRepository.save(e);
	}
	
	@Test(priority=4, dependsOnMethods={"testRemoveRoleForEmployee", "testRemoveProjectForEmployee"})
	public void deleteEmployee(){
		Employee e;
		e = employeeRepository.findByEmpId(id);
		employeeRepository.delete(e);
		
		Assert.assertEquals(e.getId(), id);
		e = employeeRepository.findByEmpId(id);
		Assert.assertEquals(e, null);
	}
}
