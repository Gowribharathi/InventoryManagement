package com.Project.InventoryManagement.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="customerTbl")
public class Customer {
	

	@Id
	@GeneratedValue(generator= "seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=10)
	private long custId;
    @Column(nullable=false)
    @NotBlank(message="First name is mandatory")
	private String firstName;
    @Column(nullable=false)
    @NotBlank(message="Last name is mandatory")
	private String lastName;
    @Column(nullable=false)
    @NotBlank(message="Contact Number is mandatory")
    @Digits(integer=10, message="Contact number must be 10 digits",fraction=0)
	private String contactNo;
    @Column(nullable=false,unique=true)
    @NotBlank(message="Email is mandatory")
    @Email(message="Invalid email id")
	private String emailId;
    @Column(nullable=false)
    @NotBlank(message="Address is mandatory")
	private String address;
    
	@ManyToMany
	@JsonIgnoreProperties("customer")
	@JoinTable(name="customer_product",joinColumns= @JoinColumn(name="custId"),
	inverseJoinColumns=@JoinColumn(name="productId"))
	private List<Product> product;
	
	@OneToMany(mappedBy="customer")
	@JsonIgnoreProperties("customer")
	private List<Purchase> purchase;
	
	
	

	public Customer(long custId, @NotBlank(message = "First name is mandatory") String firstName,
			@NotBlank(message = "Last name is mandatory") String lastName,
			@NotBlank(message = "Contact Number is mandatory") @Digits(integer = 10, message = "Contact number must be 10 digits", fraction = 0) String contactNo,
			@NotBlank(message = "Email is mandatory") @Email(message = "Invalid email id") String emailId,
			@NotBlank(message = "Address is mandatory") String address, List<Product> product,
			List<Purchase> purchase) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.address = address;
		this.product = product;
		this.purchase = purchase;
	}

	public List<Purchase> getPurchase() {
		return purchase;
	}

	public void setPurchase(List<Purchase> purchase) {
		this.purchase = purchase;
	}

	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Customer(long custId, String firstName, String lastName, String contactNo, String emailId, String address) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.address = address;
	}
	public Customer() {
		super();
		//TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNo="
				+ contactNo + ", emailId=" + emailId + ", address=" + address + ", product=" + product + ", purchase="
				+ purchase + "]";
	}
	

}
