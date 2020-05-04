package com.cg.lab.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CART_LAB")
@ApiModel("Cart Information")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty("Cart Id")
	private Integer cartId;
	
	@ManyToMany
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
