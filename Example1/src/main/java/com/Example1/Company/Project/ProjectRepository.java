package com.Example1.Company.Project;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ProjectRepository extends CrudRepository<Project, Long>{
	Project findByName(String name);
}
