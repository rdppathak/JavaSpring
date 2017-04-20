package com.Example.CustomerJPA;

import java.util.ArrayList;

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
	
	@RequestMapping("/read")
	 public ArrayList<Customer> read(@RequestParam String lastName) {
		ArrayList<Customer> customer = (ArrayList<Customer>) customerRepository.findByLastName(lastName);
		if (customer.size() == 0){
			customer = new ArrayList<Customer>();
			System.out.println("No such customer exists");
			return customer;
			
		}
		System.out.println("Found customer "+customer.get(0).getFirstName());
	    return customer;
	 }
}
