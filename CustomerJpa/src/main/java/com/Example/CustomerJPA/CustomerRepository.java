package com.Example.CustomerJPA;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public ArrayList<Customer> findByLastName(String lastName);
}
