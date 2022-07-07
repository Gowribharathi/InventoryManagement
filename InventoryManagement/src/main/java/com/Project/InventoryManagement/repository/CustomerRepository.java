package com.Project.InventoryManagement.repository;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer,Long> {

	@Query("select c from Customer c where c.firstName= :firstName")
	List<Customer> getByFirstName(@Param ("firstName") String firstName);
    
	@Query("select c from Customer c where c.lastName= :lastName")
	List<Customer> getByLastName(@Param ("lastName")String lastName);
    
	@Query("select c from Customer c where c.firstName= :firstName and c.lastName= :lastName")
	List<Customer> getCustomerByFullName(String firstName, String lastName);

	Optional<Customer> findByEmailId(String emailId);

	

}
