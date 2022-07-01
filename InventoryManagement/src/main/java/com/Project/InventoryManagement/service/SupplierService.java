package com.Project.InventoryManagement.service;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Supplier;

public interface SupplierService {

	List<Supplier> getSupplierList();

	Supplier saveSupplier(Supplier supplier);

	Optional<Supplier> getSupplierById(long id);

	Supplier updateSupplier(long id, Supplier supplier);

	String deleteSupplier(long id);

}
