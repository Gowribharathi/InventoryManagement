package com.Project.InventoryManagement.controller;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Supplier;
import com.Project.InventoryManagement.service.SupplierService;

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
@RequestMapping("/api/supplier")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@GetMapping 
	public List<Supplier> getSupplierList()
	{
		return supplierService.getSupplierList();
	}
	
	@PostMapping
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier)
	{
		return new ResponseEntity<Supplier>(supplierService.saveSupplier(supplier),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public Optional<Supplier> getSupplierById(@PathVariable ("id") long id)
	{
		return supplierService.getSupplierById(id);
	}
	
	@PutMapping("/{id}")
	public Supplier updateSupplier(@PathVariable ("id") long id,@RequestBody Supplier supplier)
	{
		return supplierService.updateSupplier(id,supplier);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteSupplier(@PathVariable("id") long id)
	{
		return new ResponseEntity<String> (supplierService.deleteSupplier(id),HttpStatus.OK);
	}

}
