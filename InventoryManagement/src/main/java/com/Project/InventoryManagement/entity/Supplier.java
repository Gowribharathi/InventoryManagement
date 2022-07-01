package com.Project.InventoryManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="supplierTbl")
public class Supplier {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long supplierId;
	private String supName;
	private String contactNo;
	private String address;
	private String email;
	public long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupName() {
		return supName;
	}
	public void setSupName(String supName) {
		this.supName = supName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Supplier(long supplierId, String supName, String contactNo, String address, String email) {
		super();
		this.supplierId = supplierId;
		this.supName = supName;
		this.contactNo = contactNo;
		this.address = address;
		this.email = email;
	}
	public Supplier() {
		super();
		//TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supName=" + supName + ", contactNo=" + contactNo + ", address="
				+ address + ", email=" + email + "]";
	}
	

}
