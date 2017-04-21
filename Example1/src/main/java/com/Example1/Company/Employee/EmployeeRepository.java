package com.Example1.Company.Employee;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	Employee findByFirstName(String firstName);
}

