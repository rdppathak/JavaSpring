package com.Example1.Company.Role;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.Example1.Company.Employee.Employee;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByTitle(String title);
}
