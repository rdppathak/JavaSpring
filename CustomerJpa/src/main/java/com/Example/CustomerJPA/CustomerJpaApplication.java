package com.Example.CustomerJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Example.CustomerJPA.CustomerJpaApplication;
import com.Example.CustomerJPA.Customer;
import com.Example.CustomerJPA.CustomerRepository;

@SpringBootApplication
public class CustomerJpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerJpaApplication.class);
	}
}
