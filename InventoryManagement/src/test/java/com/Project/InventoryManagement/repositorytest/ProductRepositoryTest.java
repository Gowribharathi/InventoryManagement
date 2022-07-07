package com.Project.InventoryManagement.repositorytest;

import java.util.List;

import java.util.Optional;

import com.Project.InventoryManagement.entity.Product;
import com.Project.InventoryManagement.repository.ProductRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProductRepositoryTest {
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void saveProductTest()
	{
		Product product=productRepository.save(new Product(2,"Samsung mobile","20000",2));
		Assertions.assertThat(product.getProductId()).isGreaterThan(0);
	}
	
    @Test
    public void getProductTest()
    {
    	Product product=productRepository.findById(2L).get();
    	Assertions.assertThat(product.getProductId()).isEqualTo(2L);
    }
    @Test
    public void getProductListTest()
    {
    	List<Product> product=productRepository.findAll();
    	Assertions.assertThat(product.size()).isGreaterThan(0);
    }
    @Test
    public void updateProductTest()
    {
    	Product product=productRepository.getById(6L);
    	product.setProductName("Redmi");
    	Product updated=productRepository.save(product);
    	Assertions.assertThat(product.getProductName()).isEqualTo("Redmi");
    }
    @Test
    public void deleteProductTest()
    {
    	Product product=productRepository.findById(10L).get();
    	productRepository.delete(product);
    	Product products=null;
        Optional<Product> product1=productRepository.findById(10L);
       if(product1.isPresent())
       {
    	   products=product1.get();
       }
       Assertions.assertThat(products).isNull();
    }
}
