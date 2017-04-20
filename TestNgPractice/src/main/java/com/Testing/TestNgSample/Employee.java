package com.Testing.TestNgSample;

class InvalidSalary extends Exception{
	
}

class InvalidAge extends Exception{
	
}

public class Employee {
	private String firstName;
	private String lastName;
	private int age;
	private float salary;
	
	
	public Employee(){}
	
	public Employee(String firstName, String lastName, int age, float salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.salary = salary;
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
	public void setAge(int age) throws InvalidAge {
		if (age < 18){
			throw new InvalidAge();
		}
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) throws InvalidSalary {
		if (salary <=0){
			throw new InvalidSalary();
		}
		this.salary = salary;
	}
	
	
}
