package com.Project.InventoryManagement.service;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Customer;

import org.springframework.http.HttpStatus;


public interface CustomerService {

	List<Customer> getCustomerList();

	Customer saveCustomer(Customer customer);

	Optional<Customer> getCustomerById(long id);

	Customer updateCustomer(long id, Customer customer);

	String deleteCustomer(long id);

	List<Customer> getCustomerByFirstName(String firstName);

	List<Customer> getCustomerByLastName(String lastName);

	List<Customer> getCustomerByFullName(String firstName, String lastName);

	Optional<Customer> getCustomerByEmail(String emailId);

	

	

}
