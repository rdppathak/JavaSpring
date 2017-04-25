package com.Example1.Company.Project;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROJECT_ID")
	private long id;
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
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
