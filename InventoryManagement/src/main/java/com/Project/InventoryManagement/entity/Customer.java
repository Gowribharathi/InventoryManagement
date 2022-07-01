package com.Project.InventoryManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerTbl")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long custId;
	private String firstName;
	private String lastName;
	private String contactNo;
	private String emailId;
	private String address;
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
				+ contactNo + ", emailId=" + emailId + ", address=" + address + "]";
	}
	

}
