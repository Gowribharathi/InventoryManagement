package com.Project.InventoryManagement.controller;



import java.util.List;



import java.util.Optional;

import javax.validation.Valid;

import com.Project.InventoryManagement.entity.Product;
import com.Project.InventoryManagement.service.ProductService;

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
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping
	public List<Product> getProductList()
	{
		return productService.getProductList();
	}
	
	@PostMapping
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)
	{
		return new ResponseEntity<Product> (productService.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping ("/{id}")
	public Optional<Product> getProductById(@PathVariable ("id") long id)
	{
		return productService.getProductById(id);
	}
	
	@PutMapping ("/{id}")
	public Product  updateProduct(@PathVariable ("id") long id,@Valid @RequestBody Product product)
	{
		return productService.updateproduct(id, product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable ("id") long id)
	{
		return new ResponseEntity<String> (productService.deleteProduct(id),HttpStatus.OK);
	}
}
