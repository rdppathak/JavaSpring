package com.Example1.Company.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import com.Example1.Company.Role.Role;

interface EmployeeDAO{
	public Employee addEmployee(String firstName, String lastName, String emailId, int age, double salary);
	public Employee addRoleForEmployee(String firstName, String lastName, Role role);
}

public class EmployeeService implements EmployeeDAO{
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee addEmployee(String firstName, String lastName, String emailId, int age, double salary){
		Employee e = new Employee();
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setEmail(emailId);
		e.setAge(age);
		e.setSalary(salary);
		employeeRepository.save(e);
		return e;
	}

	public Employee addRoleForEmployee(String firstName, String lastName, Role role) {
		Employee e;
		e = employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		e.setRole(role);
		employeeRepository.save(e);
		return e;
	}
}
