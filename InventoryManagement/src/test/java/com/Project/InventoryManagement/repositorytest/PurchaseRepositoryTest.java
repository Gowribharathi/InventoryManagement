package com.Project.InventoryManagement.repositorytest;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Customer;
import com.Project.InventoryManagement.entity.Purchase;
import com.Project.InventoryManagement.repository.PurchaseRepository;

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
public class PurchaseRepositoryTest {
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Test
	public void savePurchaseTest()
	{
		Purchase purchase=purchaseRepository.save(new Purchase(15L,10L,null,"TV","3",24000L,72000L,null));
		Assertions.assertThat(purchase.getId()).isGreaterThan(0);
	}
	@Test
	public void getPurchaseListTest()
	{
		List<Purchase> purchase=purchaseRepository.findAll();
		Assertions.assertThat(purchase.size()).isGreaterThan(0);
	}
	@Test
	public void getPurchaseByIdTest()
	{
		Purchase purchase=purchaseRepository.findById(10L).get();
		Assertions.assertThat(purchase.getPurchaseId()).isEqualTo(10L);
		
	}
	
	@Test
	public void updatePurchaseTest()
	{
		Purchase purchase=purchaseRepository.findById(17L).get();
		purchase.setProductName("Tv");
		Purchase updated=purchaseRepository.save(purchase);
		Assertions.assertThat(updated.getProductName()).isEqualTo("Tv");
	}
	
	@Test
	public void deletePurchaseTest()
	{
		Purchase purchase=purchaseRepository.findById(16L).get();
		purchaseRepository.delete(purchase);
		Purchase purchases=null;
		Optional<Purchase> purchase1=purchaseRepository.findById(16L);
		if(purchase1.isPresent()) {
			purchases=purchase1.get();
		}
		Assertions.assertThat(purchases).isNull();
	}
	

}
