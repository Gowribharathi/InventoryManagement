package com.Project.InventoryManagement.repository;




import com.Project.InventoryManagement.entity.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository <Supplier, Long> {

	

}
