package com.Example1.Company.Role;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface RoleRepository extends CrudRepository<Role, Long>{

}
