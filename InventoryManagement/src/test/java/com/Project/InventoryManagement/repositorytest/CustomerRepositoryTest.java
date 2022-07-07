package com.Project.InventoryManagement.repositorytest;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Customer;
import com.Project.InventoryManagement.repository.CustomerRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTest {
   
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	public void saveCustomerTest()
	{
		Customer customer=customerRepository.save(new Customer(1,"Gowribharathi","Ravi","6987839838","gowri@gmail.com","Poolampatti main road,salem"));
		Assertions.assertThat(customer.getCustId()).isGreaterThan(0);
	}
	
	@Test
	public void getCustomerListTest()
	{
		List<Customer> customer=customerRepository.findAll();
		Assertions.assertThat(customer.size()).isGreaterThan(0);
	}
	@Test
	public void getCustomerByIdTest()
	{
		Customer customer=customerRepository.findById(1L).get();
		Assertions.assertThat(customer.getCustId()).isEqualTo(1L);
		
	}
	
	@Test
	public void updateCustomerTest()
	{
		Customer customer=customerRepository.findById(1L).get();
		customer.setEmailId("gowri23@gmail.com");
		Customer updated=customerRepository.save(customer);
		Assertions.assertThat(updated.getEmailId()).isEqualTo("gowri23@gmail.com");
	}
	
	@Test
	public void deleteCustomerTest()
	{
		Customer customer=customerRepository.findById(103L).get();
		customerRepository.delete(customer);
		Customer customers=null;
		Optional<Customer> customer1=customerRepository.findById(103L);
		if(customer1.isPresent()) {
			customers=customer1.get();
		}
		Assertions.assertThat(customers).isNull();
	}
	
	@Test
	public void getCustomerByFirstNameTest()
	{
		List<Customer> customer=customerRepository.getByFirstName("Gowribharathi");
		Assertions.assertThat(customer);
		
	}
	
	@Test
	public void getCustomerByLastNameTest()
	{
		List<Customer> customer=customerRepository.getByLastName("Ravi");
		Assertions.assertThat(customer);
	}
	@Test
	public void getCustomerByFullNameTest()
	{
		List<Customer> customer=customerRepository.getCustomerByFullName("Gowribharathi","Ravi");
		Assertions.assertThat(customer);
	}
	@Test
	public void getCustomerByEmailIdTest()
	{
		Optional<Customer> customer=customerRepository.findByEmailId("gowri@gmail.com");
		Assertions.assertThat(customer);
	}
}
