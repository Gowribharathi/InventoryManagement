package com.Project.InventoryManagement.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.Project.InventoryManagement.entity.Purchase;
import com.Project.InventoryManagement.service.PurchaseService;

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
@RequestMapping("/api/purchase")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	
	@PostMapping
	public ResponseEntity<Purchase> getPurchaseList(@Valid @RequestBody Purchase purchase){
		return new ResponseEntity<Purchase> (purchaseService.savePurchase(purchase),HttpStatus.CREATED);
	}
    
	@GetMapping
	public List<Purchase> getPurchaseList(){
		return purchaseService.getPurchaseList();
	}
	
	@GetMapping("/{id}")
	public Purchase getPurchaseById(@PathVariable("id") long id) {
		return purchaseService.getPurchaseById(id);
	}
	@PutMapping("/{id}")
	public Purchase updatePurchaseById(@PathVariable("id") long id,@Valid @RequestBody Purchase purchase) {
		return purchaseService.updatePurchaseById(id,purchase);
	}
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePurchaseById(@PathVariable ("id") long id){
		return new ResponseEntity<String> (purchaseService.deletePurchaseById(id),HttpStatus.CREATED);
	}
	@GetMapping("/GetByPurchaseId/{purchaseId}")
	public List<Purchase> getByPurchaseId(@PathVariable("purchaseId") long purchaseId){
		return purchaseService.getByPurchaseId(purchaseId);
	}
	@GetMapping("/GetPurchaseByProductName/{ProductName}")
	public List<Purchase> getPurchaseByProductName(@PathVariable("ProductName") String productName)
	{
		return purchaseService.getPurchaseByProductName(productName);
	}
	@GetMapping("/GetByPurchaseTotalCost/{totalCost}")
	public List<Purchase> getByTotalCost(@PathVariable("totalCost")double totalCost){
		return purchaseService.getByTotalCost(totalCost);
	}
	@GetMapping("/GetByPurchaseDate/{date}")
	public List<Purchase> getByDate(@PathVariable("date") String date){
		return purchaseService.getByDate(LocalDate.parse(date));
	}
	
	
	
	
	
	
	
	
	
	
}
