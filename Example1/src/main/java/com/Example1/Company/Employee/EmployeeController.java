package com.Example1.Company.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Example1.Company.Employee.*;

import com.Example1.Company.Project.Project;
import com.Example1.Company.Project.ProjectRepository;
import com.Example1.Company.Role.Role;
import com.Example1.Company.Role.RoleRepository;
import com.Example1.Company.Role.RoleService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	ProjectRepository departmentRepository;
	
	EmployeeService es = new EmployeeService();
	RoleService rs = new RoleService();
	
	@RequestMapping("/createEmployee")
	public Employee create(@RequestParam(value = "firstName", defaultValue = "User") String firstName,
			@RequestParam(value = "lastName", defaultValue = "lastName") String lastName,
			@RequestParam(value="emailid") String emailid,
			@RequestParam(value = "age", defaultValue = "25") int age,
			@RequestParam(value = "salary", defaultValue = "10000") float salary) {
		return es.addEmployee(firstName, lastName, emailid, age, salary);
	}

	@RequestMapping("/addEmployeeRole")
	public void setEmployeeRole(@RequestParam(value="firstName") String firstName,
						@RequestParam(value="lastName") String lastName,
						@RequestParam(value="title") String title,
						@RequestParam(value="description") String description){
		es.addRoleForEmployee(firstName, lastName, rs.addRole(title, description));
	}
	
	@RequestMapping("/FetchEmployee")
	public Employee FetchEmployee(@RequestParam(value="id") long id){
		Employee employee = null;
		employee = employeeRepository.findByEmpId(id);
		return employee;
	}
	
	@RequestMapping("/FetchAllEmployees")
	public ArrayList FetchAllEmployees(){
		ArrayList empList = (ArrayList) employeeRepository.findAll();
		return empList;
	}
	
	@RequestMapping("/addEmployeeProject")
	public Employee setEmployeeProject(@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="name") String projName,
			@RequestParam(value="description") String description){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if (e == null){
			return e;
		}else{
			Project p = null;
			p = departmentRepository.findByName(projName);
			if (p==null){
				p = new Project(projName, description);
			}
			departmentRepository.save(p);
			e.setProject(p);
			employeeRepository.save(e);			
		}
		return e;
	}
	
	@RequestMapping("/removeRole")
	public Employee removeEmployeeRole(@RequestParam(value="firstName") String firstName,
					@RequestParam(value="lastName") String lastName,
					@RequestParam(value="title") String title){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		if (e == null){
			return e;
		}else{
			e.removeRole(title);
		}
		employeeRepository.save(e);
		return e;
	}
	
	@RequestMapping("/deleteEmployee")
	public Employee deleteEmployeeDetails(@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName){
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		employeeRepository.delete(e);
		return null;
	}
	
	
}
