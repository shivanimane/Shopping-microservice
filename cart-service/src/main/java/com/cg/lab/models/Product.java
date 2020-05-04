package com.cg.lab.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PRODUCTS_LAB")
@ApiModel("Product Bean")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("Product Id")
	private Integer productId;
	
	@Column
	@ApiModelProperty("Product Name")
	private String productName;
	
	@Column
	@ApiModelProperty("Product Price")
	private double productPrice;
	
	@Column
	@ApiModelProperty("Category")
	private String category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(String productName, double productPrice, String category) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}
	
	
}
