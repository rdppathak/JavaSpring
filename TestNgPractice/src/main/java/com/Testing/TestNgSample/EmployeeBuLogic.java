package com.Testing.TestNgSample;

public class EmployeeBuLogic {

	public float calculateAnnualSalary(Employee emp){
		return emp.getSalary()*12;
	}
	
	public float calculateAppraisal(Employee emp){
		float salary = emp.getSalary();
		float appraisal = 0;
		if (salary < 10000){
			appraisal = 500;
		}else{
			appraisal = 1000;
		}
		
		return appraisal;
	}
}
