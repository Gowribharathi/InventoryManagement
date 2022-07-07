package com.Project.InventoryManagement.repositorytest;

import java.util.List;
import java.util.Optional;


import com.Project.InventoryManagement.entity.Supplier;
import com.Project.InventoryManagement.repository.SupplierRepository;

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
public class SupplierRepositoryTest {
	@Autowired
	SupplierRepository supplierRepository;
	
	@Test
	public void saveSupplierTest()
	{
		Supplier supplier=supplierRepository.save(new Supplier(153,"Rapidwifi","9674343878","Salem","abc@gmail.com"));
	   Assertions.assertThat(supplier.getSupplierId()).isGreaterThan(0);
	}
	@Test
	public void getSupplierTest()
	{
		Supplier supplier = supplierRepository.findById(153L).get();
		Assertions.assertThat(supplier.getSupplierId()).isEqualTo(153L);
				
	}
	
	@Test
	public void getSupplierListTest()
	{
		List<Supplier> supplier = supplierRepository.findAll();
		Assertions.assertThat(supplier.size()).isGreaterThan(0);
		
	}
	@Test
    public void updateSupplierTest()
    {
    	Supplier supplier=supplierRepository.getById(152L);
    	supplier.setSupName("Rapid Tech");
    	Supplier updated=supplierRepository.save(supplier);
    	Assertions.assertThat(updated.getSupName()).isEqualTo("Rapid Tech");
    }
    @Test
    public void deleteSupplierTest()
    {
    	Supplier supplier=supplierRepository.findById(154L).get();
    	supplierRepository.delete(supplier);
    	Supplier suppliers=null;
        Optional<Supplier> supplier1=supplierRepository.findById(154L);
       if(supplier1.isPresent())
       {
    	 suppliers=supplier1.get();
       }
       Assertions.assertThat(suppliers).isNull();
    }
}