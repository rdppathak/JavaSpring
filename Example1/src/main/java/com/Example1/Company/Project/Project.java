package com.Example1.Company.Project;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="projects")
@Proxy(lazy=false)
@Transactional
public class Project {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long projectId;
	@Column(unique=true)
	private String name;
	@Column
	private String description;
	
	public Project(){
		
	}
	
	public Project(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	public long getId() {
		return projectId;
	}
	public void setId(long id) {
		this.projectId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
