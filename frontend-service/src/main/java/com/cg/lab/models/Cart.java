package com.cg.lab.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Cart Information")
public class Cart {
	
	@ApiModelProperty("Cart Id")
	private Integer cartId;
	
	@ApiModelProperty("List of Products")
	private List<Product> productList = new ArrayList<Product>();

	public Cart() {
		// TODO Auto-generated constructor stub  
	}
	
	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Cart(Integer cartId, List<Product> productList) {
		super();
		this.cartId = cartId;
		this.productList = productList;
	}

	public void addProduct(Product product) {
		productList.add(product);
	}
	
	public void deleteProduct(Integer productId) {
		productList = productList.stream().filter(p->p.getProductId()!=productId).collect(Collectors.toList());
	}

}
