package com.Project.InventoryManagement.entity;

import java.time.LocalDate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="purchaseTbl")
public class Purchase {
  
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",initialValue=1000)
	private long id;
	private long purchaseId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	@Column(nullable=false)
	@NotBlank(message="Product name is mandatory")
	private String productName;
	private String quantity;
	private double unitPrice;
	private double totalCost;
	
	@ManyToOne
	@JsonIgnoreProperties("purchase")
	private Customer customer;
	private LocalDate purchaseDate;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Purchase(long id, long purchaseId, LocalDate date, String productName, String quantity, double unitPrice,
			double totalCost, Customer customer) {
		super();
		this.id = id;
		this.purchaseId = purchaseId;
		this.date = date;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalCost = totalCost;
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Purchase() {
		super();
		//TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", purchaseId=" + purchaseId + ", date=" + date + ", productName=" + productName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + ", totalCost=" + totalCost + ", customer="
				+ customer + "]";
	}
	
	
}
