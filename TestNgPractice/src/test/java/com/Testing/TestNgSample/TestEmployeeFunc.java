package com.Testing.TestNgSample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEmployeeFunc {
	EmployeeBuLogic empBusinessLogic = new EmployeeBuLogic();
	Employee employee = new Employee();

	   @Test
	   public void testCalculateAppriasal() throws InvalidSalary, InvalidAge {
	   
	      employee.setFirstName("Rajeev");
	      employee.setLastName("Shukla");
	      employee.setAge(25);
	      employee.setSalary(8000);
	      
	      double appraisal = empBusinessLogic.calculateAppraisal(employee);
	      Assert.assertEquals(500, appraisal, 0.0, "500");
	   }

	   // Test to check yearly salary
	   @Test
	   public void testCalculateYearlySalary() throws InvalidSalary, InvalidAge {
	   
	      employee.setFirstName("Rajeev");
	      employee.setLastName("Shukla");
	      employee.setAge(25);
	      employee.setSalary(8000);
	      
	      double salary = empBusinessLogic.calculateAnnualSalary(employee);
	      Assert.assertEquals(96000, salary, 0.0, "8000");
	   }
	   
	   @Test(expectedExceptions = InvalidSalary.class)
	   public void testInvalidSalaryValue() throws InvalidSalary, InvalidAge{
		   employee.setFirstName("Rajeev");
		   employee.setLastName("Shukla");
		   employee.setAge(25);
		   employee.setSalary(0);
		   
	   }
	   
	   @Test(expectedExceptions = InvalidAge.class)
	   public void testInvalidAgeValue() throws InvalidSalary, InvalidAge{
		   employee.setFirstName("Rajeev");
		   employee.setLastName("Shukla");
		   employee.setAge(15);
	   }
}
