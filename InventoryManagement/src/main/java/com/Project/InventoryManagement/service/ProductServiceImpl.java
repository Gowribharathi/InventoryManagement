package com.Project.InventoryManagement.service;

import java.util.List;



import java.util.Optional;

import com.Project.InventoryManagement.entity.Product;
import com.Project.InventoryManagement.exception.GivenIdNotFoundException;
import com.Project.InventoryManagement.exception.NoRecordFoundException;
import com.Project.InventoryManagement.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getProductList() {
		List<Product> product=productRepository.findAll();
		if(product.isEmpty())
		{
			throw new NoRecordFoundException();
		}else
		{
			
		return product;
		}
	}

	@Override
	public Product saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProductById(long id) {
		Optional<Product> product= productRepository.findById(id);
		if(product.isPresent())
		{
			return product;
		}
		else
		{
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Product updateproduct(long id, Product product) {
		Product products = new Product();
		products = productRepository.findById(id).orElseThrow(()-> new NoRecordFoundException());
		products.setProductId(product.getProductId());
		products.setProductName(product.getProductName());
		products.setPrice(product.getPrice());
		products.setQuantity(product.getQuantity());
		
		return products;
	}

	@Override
	public String deleteProduct(long id) {
		Product product=new Product();
		product = productRepository.findById(id).orElseThrow( ()-> new NoRecordFoundException());
		productRepository.deleteById(id);
		return "Record is deleted Successfully";
	}

}
