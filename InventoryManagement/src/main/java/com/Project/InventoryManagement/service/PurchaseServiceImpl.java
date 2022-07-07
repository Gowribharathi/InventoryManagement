package com.Project.InventoryManagement.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Purchase;
import com.Project.InventoryManagement.exception.CostNotFoundException;
import com.Project.InventoryManagement.exception.GivenIdNotFoundException;
import com.Project.InventoryManagement.exception.NameNotFoundException;
import com.Project.InventoryManagement.exception.NoRecordFoundException;
import com.Project.InventoryManagement.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    
	@Autowired
	PurchaseRepository purchaseRepository;
	@Override
	public Purchase savePurchase(Purchase purchase) {
		
		return purchaseRepository.save(purchase);
	}
	@Override
	public List<Purchase> getPurchaseList() {
		List<Purchase> purchases=purchaseRepository.findAll();
		if(purchases.isEmpty()){
			throw new NoRecordFoundException();
		}
		else
		{
		return purchases;
	}

}
	@Override
	public Purchase getPurchaseById(long id) {
		Optional<Purchase> purchase=purchaseRepository.findById(id);
		if(purchase.isPresent()) {
			return purchase.get();
		}else {
			throw new GivenIdNotFoundException();
		}
				
	}
	@Override
	public Purchase updatePurchaseById(long id, Purchase purchase) {
		Purchase purchases=new Purchase();
		purchases.setPurchaseId(purchase.getPurchaseId());
		purchases.setDate(purchase.getDate());
		purchases.setProductName(purchase.getProductName());
		purchases.setQuantity(purchase.getQuantity());
		purchases.setUnitPrice(purchase.getUnitPrice());
		purchases.setTotalCost(purchase.getTotalCost());
		purchaseRepository.save(purchases);
		return purchases;
	}
	@Override
	public String deletePurchaseById(long id) {
		Purchase purchase=new Purchase();
		purchase=purchaseRepository.findById(id).orElseThrow (()-> new GivenIdNotFoundException());
		purchaseRepository.delete(purchase);
		return "Record Deleted Successfully";
	}
	@Override
	public List<Purchase> getByPurchaseId(long purchaseId) {
		List<Purchase> purchase=purchaseRepository.findByPurchaseId(purchaseId);
		if(purchase.isEmpty()) {
			throw new GivenIdNotFoundException();
		}else
		{
		return purchase;}
	}
	@Override
	public List<Purchase> getPurchaseByProductName(String productName) {
		List<Purchase> purchase=purchaseRepository.findByProductName(productName);
		if(purchase.isEmpty()) {
			throw new NameNotFoundException();
		}else
		{
		return purchase;}
	}
	@Override
	public List<Purchase> getByTotalCost(double totalCost) {
		List<Purchase> purchase=purchaseRepository.findByTotalCost(totalCost);
		if(purchase.isEmpty()) {
			throw new CostNotFoundException();
		}else {
		return purchase;}
	}
	@Override
	public List<Purchase> getByDate(LocalDate date) {
		List<Purchase> purchase=purchaseRepository.findByDate(date);
		if(purchase.isEmpty()) {
			throw new NoRecordFoundException();
		}
		return purchase;
	}
}
