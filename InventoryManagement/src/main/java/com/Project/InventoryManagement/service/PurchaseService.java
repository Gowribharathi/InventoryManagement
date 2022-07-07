package com.Project.InventoryManagement.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.Project.InventoryManagement.entity.Purchase;

public interface PurchaseService {

	Purchase savePurchase(Purchase purchase);

	List<Purchase> getPurchaseList();

	Purchase getPurchaseById(long id);

	Purchase updatePurchaseById(long id, Purchase purchase);

	String deletePurchaseById(long id);

	List<Purchase> getByPurchaseId(long purchaseId);



	List<Purchase> getByTotalCost(double totalCost);

	List<Purchase> getByDate(LocalDate date);

	List<Purchase> getPurchaseByProductName(String productName);
}
