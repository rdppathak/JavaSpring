package com.Example.CustomerJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping("/create")
	 public Customer create(@RequestParam(value="firstName", defaultValue="User") String firstName, @RequestParam(value="lastName", defaultValue="lastName") String lastName) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
	  customer = customerRepository.save(customer);
	  return customer;
	 }
}
