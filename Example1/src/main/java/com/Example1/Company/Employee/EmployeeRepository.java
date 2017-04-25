package com.Example1.Company.Employee;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	Employee findByFirstNameAndLastName(String firstName, String lastName);
	Employee findByEmpId(long empId);
//	Set<Employee> findAll();
}

