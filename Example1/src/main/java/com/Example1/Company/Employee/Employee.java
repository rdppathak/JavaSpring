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
import javax.transaction.Transactional;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="Employees", uniqueConstraints={@UniqueConstraint(columnNames = {"firstName", "lastName"})})
@Proxy(lazy=false)
@Transactional
public class Employee {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long empId;
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
	
	@ManyToMany(targetEntity=Role.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "EMP_ROLE", joinColumns = @JoinColumn(name="empId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> role;
	
	@ManyToMany(targetEntity=Project.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "EMP_PROJECT", joinColumns = @JoinColumn(name = "empId"), inverseJoinColumns = @JoinColumn(name="projectId"))
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
		return empId;
	}
	public void setId(long id) {
		this.empId = id;
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
		Role r = null;
		for (Role rr : this.role) {
		    if(rr.getTitle().equals(title)){
		    	r = rr;
		    	break;
		    }
		}
		if(r != null){
			this.role.remove(r);
		}
	}
	public Set<Project> getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project.add(project);
	}
	
	public void removeProject(String projectName){
		for(Project p: this.project){
			if(p.getName().equals(projectName)){
				this.project.remove(p);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", salary=" + salary + ", email=" + email + ", role=" + role + ", project=" + project + "]";
	}
	
	
}
