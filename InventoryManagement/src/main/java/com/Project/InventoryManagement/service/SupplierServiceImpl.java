package com.Project.InventoryManagement.service;

import java.util.List;
import java.util.Optional;

import com.Project.InventoryManagement.entity.Supplier;
import com.Project.InventoryManagement.exception.GivenIdNotFoundException;
import com.Project.InventoryManagement.exception.NoRecordFoundException;
import com.Project.InventoryManagement.repository.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SupplierServiceImpl implements SupplierService{
	@Autowired
	SupplierRepository supplierRepository;
	
	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<Supplier> getSupplierList() {
		List<Supplier> supplier= supplierRepository.findAll();
		if(supplier.isEmpty()) {
			throw new NoRecordFoundException();
		}else 
		{
		return supplier;
	}}

	@Override
	public Supplier saveSupplier(Supplier supplier) {
		
		return supplierRepository.save(supplier);
	}

	@Override
	public Optional<Supplier> getSupplierById(long id) {
		Optional<Supplier> supplier=supplierRepository.findById(id);
		if(supplier.isPresent())
		{
		return supplier;
		}else
		{
			throw new GivenIdNotFoundException();
		}
	}

	@Override
	public Supplier updateSupplier(long id, Supplier supplier) {
		Supplier suppliers=new Supplier();
		suppliers= supplierRepository.findById(id).orElseThrow (()->new NoRecordFoundException());
		suppliers.setSupplierId(supplier.getSupplierId());
		suppliers.setSupName(supplier.getSupName());
		suppliers.setContactNo(supplier.getContactNo());
		suppliers.setAddress(supplier.getAddress());
		suppliers.setEmail(supplier.getEmail());
		
		return suppliers;
	}

	@Override
	public String deleteSupplier(long id) {
		Supplier supplier=new Supplier();
		supplier = supplierRepository.findById(id).orElseThrow ( ()-> new NoRecordFoundException());
		supplierRepository.deleteById(id);
		return "Record is deleted successfully";
	}
	
}
