package com.cmigut.microservices.pfcustomer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cmigut.microservices.pfcustomer.domain.Customer;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@RestController
public class CustomerController {
	
	List<Customer> customers = new ArrayList<Customer>();
	
	@GetMapping("/customers")
	public List<Customer> retrieveCustomers(){		
		
		customers.add(new Customer(1, "Roosevelt", "Reneau", 30));
		customers.add(new Customer(2, "Kimberley", "Kulpa", 42));
		customers.add(new Customer(3, "Connie", "Casselman", 25));
		customers.add(new Customer(4, "Bettyann", "Barkley", 20));
		
		return customers;
	}
	
	@GetMapping("/customers/{id}")
	public Customer retrieveCustomerById(@PathVariable Integer id){
		Customer customer;
		customer = customers.stream().filter(x -> x.getId() == id).findFirst().get();
		
		if(customer != null){
			
		}
		return customer;
	}
}
