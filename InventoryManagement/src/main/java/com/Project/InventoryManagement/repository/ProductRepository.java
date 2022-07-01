package com.Project.InventoryManagement.repository;

import com.Project.InventoryManagement.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {

}
