package com.cg.lab.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Product Information")
public class Product {
	
	@ApiModelProperty("Product Id")
	private Integer productId;
	
	@ApiModelProperty("Product Name")
	private String productName;
	
	@ApiModelProperty("Product Price")
	private double productPrice;
	
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
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}
	
	
}
