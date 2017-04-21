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
	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class);
	}
}
