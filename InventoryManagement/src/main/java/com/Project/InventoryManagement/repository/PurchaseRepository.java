package com.Project.InventoryManagement.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.Project.InventoryManagement.entity.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{

	List<Purchase> findByPurchaseId(long purchaseId);

	List<Purchase> findByProductName(String productName);

	List<Purchase> findByTotalCost(double totalCost);

	

	List<Purchase> findByDate(LocalDate date);

}
