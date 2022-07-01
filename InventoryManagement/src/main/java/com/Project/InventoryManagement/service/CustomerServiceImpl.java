package com.Project.InventoryManagement.service;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Customer;
import com.Project.InventoryManagement.exception.GivenIdNotFoundException;
import com.Project.InventoryManagement.exception.NoRecordFoundException;
import com.Project.InventoryManagement.exception.ResourceNotFoundException;
import com.Project.InventoryManagement.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImpl implements CustomerService{
@Autowired
CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
	super();
	this.customerRepository = customerRepository;
}

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customer=customerRepository.findAll();
		if(customer.isEmpty())
		{
			throw new NoRecordFoundException();
		}
		else
		{
			return customer;
		}
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(long id) {
		Optional<Customer> customer=(customerRepository.findById(id));
		if(customer.isPresent())
		{
			return customer;
		}else
		{
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Customer updateCustomer(long id, Customer customer) {
		Customer customers=new Customer();
		customers=customerRepository.findById(id).orElseThrow ( ()-> new NoRecordFoundException());
		customers.setFirstName(customer.getFirstName());
		customers.setLastName(customer.getLastName());
		customers.setContactNo(customer.getContactNo());
		customers.setEmailId(customer.getEmailId());
		customers.setAddress(customer.getAddress());
		customerRepository.save(customers);
		return customers;
		
	}

	@Override
	public String deleteCustomer(long id) {
		Customer customer=new Customer();
		customer=customerRepository.findById(id).orElseThrow( ()-> new ResourceNotFoundException("Customer","id",id));
		customerRepository.deleteById(id);
		return "Record is deleted successfully";
	}

}
