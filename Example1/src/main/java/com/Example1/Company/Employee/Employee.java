package com.Example1.Company.Employee;

import com.Example1.Company.Project.Project;
import com.Example1.Company.Role.Role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private int age;
	@Column
	private int salary;
	
	@OneToMany
	@JoinTable(name = "EMP_ROLE", joinColumns = @JoinColumn(name = "EMPLOYEES_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ROLES_ID", referencedColumnName = "ID"))
	private Set<Role> role;
	
	@OneToMany
	@JoinTable(name = "EMP_PROJECT", joinColumns = @JoinColumn(name = "EMPLOYEES_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name="PROJECT_ID",  referencedColumnName = "ID"))
	private Set<Project> project;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	
	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Set<Project> project) {
		this.project = project;
	}
	
	
}
