package com.Project.InventoryManagement.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="supplierTbl")
public class Supplier {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=1001)
	private long supplierId;
	@Column(nullable=false)
	@NotBlank(message="Supplier name is mandatory")
	private String supName;
	@Column(nullable=false)
	@NotBlank(message="Contact number is mandatory")
	@Digits(integer=10,message="Contact Number must be 10 digits",fraction=0)
	private String contactNo;
	private String address;
	@Column(nullable=false, unique=true)
	@NotBlank(message="Email id is mandatory")
	@Email(message="Invalid email id")
	private String email;
	@OneToMany(mappedBy="supplier")
	private List<Product> product;
	
	public Supplier(long supplierId, String supName, String contactNo, String address, String email,
			List<Product> product) {
		super();
		this.supplierId = supplierId;
		this.supName = supName;
		this.contactNo = contactNo;
		this.address = address;
		this.email = email;
		this.product = product;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
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
				+ address + ", email=" + email + ", product=" + product + "]";
	}
	

}
