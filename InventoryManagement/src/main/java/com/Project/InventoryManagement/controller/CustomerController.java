  package com.Project.InventoryManagement.controller;

import java.util.List;


 

import java.util.Optional;

import javax.validation.Valid;

import com.Project.InventoryManagement.entity.Customer;
import com.Project.InventoryManagement.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping
	public List<Customer> getCustomerList()
	{
		return customerService.getCustomerList();
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer)
	{
		return new ResponseEntity<Customer> (customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") long id)
	{
		return customerService.getCustomerById(id);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable("id") long id,@Valid @RequestBody Customer customer)
	{
		return customerService.updateCustomer(id,customer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id)
	{
		return new ResponseEntity<String> (customerService.deleteCustomer(id),HttpStatus.OK);
	}
	
	@GetMapping("/firstname/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable("firstName") String firstName)
	{
		return customerService.getCustomerByFirstName(firstName);
	}
	
	@GetMapping("/lastName/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable("lastName") String lastName)
	{
		return customerService.getCustomerByLastName(lastName);
	}
	
	@GetMapping("/GetCustomerByFullName/{firstName}/{lastName}")
	public List<Customer> getCustomerByFullName(@PathVariable ("firstName") String firstName, @PathVariable ("lastName") String lastName)
	{
		return customerService.getCustomerByFullName(firstName,lastName);
	}
	
	@GetMapping("/GetCustomerByEmail/{emailId}")
	public Optional<Customer> getCustomerByEmail(@PathVariable ("emailId") String emailId)
	{
		return customerService.getCustomerByEmail(emailId);
	}
	
	
	

}
