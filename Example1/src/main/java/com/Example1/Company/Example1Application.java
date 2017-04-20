package com.Example1.Company;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Example1.Company.Employee.Employee;
import com.Example1.Company.Employee.EmployeeRepository;
import com.Example1.Company.Project.Project;
import com.Example1.Company.Project.ProjectRepository;
import com.Example1.Company.Role.Role;
import com.Example1.Company.Role.RoleRepository;


@SpringBootApplication
public class Example1Application {
	
//	@Autowired
//    private EmployeeRepository employeeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeRepository er, RoleRepository rr, ProjectRepository pr) {
		return (args) -> {
			System.out.println("Creating Employee entry");
	        Employee e = new Employee();
	        Role r = new Role("Software Engineer", "Programming");
	        Project p = new Project("Mindsphere", "IOT Platform");
	        
	        pr.save(p);
	        rr.save(r);
	        e.setFirstName("john");
	        e.setLastName("quest");
	        
	        Set<Role> sr = new HashSet<Role>();
	        Set<Project> sp= new HashSet<Project>();
	        sp.add(p);
	        sr.add(r);
	        e.setRole(sr);
	        e.setProject(sp);
	        er.save(e);	        
			Thread.sleep(10);
		};
        
    }
}
