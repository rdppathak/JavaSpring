package com.Example1.Company.Employee;

import com.Example1.Company.Project.Project;
import com.Example1.Company.Role.Role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Employees", uniqueConstraints={@UniqueConstraint(columnNames = {"firstName", "lastName"})})
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
	private double salary;
	@Column
	String email;
	
	@ManyToMany(targetEntity=Role.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "EMP_ROLE", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> role;
	
	@ManyToMany(targetEntity=Project.class, cascade = CascadeType.ALL)
	@JoinTable(name = "EMP_DEPARTMENT", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name="PROJECT_ID"))
	private Set<Project> project;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employee(){
		firstName = null;
		lastName=null;
		email = null;
		age=0;
		salary=0;
		role = new HashSet<Role>();
		project = new HashSet<Project>();
	}

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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		if(this.role==null){
			this.role = new HashSet<Role>();
		}
		this.role.add(role);
	}

	public void removeRole(String title){
		for (Role r : this.role) {
		    if(r.getTitle()==title){
		    	this.role.remove(r);
		    	break;
		    }
		}
	}
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project.add(project);
	}
	
	
}
