package com.Project.InventoryManagement.service;

import java.util.List;

import java.util.Optional;

import com.Project.InventoryManagement.entity.Product;

public interface ProductService {

	List<Product> getProductList();

	Product saveProduct(Product product);

	Optional<Product> getProductById(long id);

	Product updateproduct(long id, Product product);

	String deleteProduct(long id);

}
