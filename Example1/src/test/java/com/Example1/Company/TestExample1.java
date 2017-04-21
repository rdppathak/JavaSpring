package com.Example1.Company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.Example1.Company.Employee.Employee;
import com.Example1.Company.Employee.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureAfter
@AutoConfigureTestDatabase
public class TestExample1 {
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    EmployeeRepository repository;

	@Test
	public void CreateEmployee() {
		Employee e = new Employee();
		e.setFirstName("firstName");
		e.setLastName("lastName");
		e.setAge(25);
		e.setSalary(20000);
		repository.save(e);
	}
}
