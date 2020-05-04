package com.cg.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lab.dao.CartDao;
import com.cg.lab.models.Cart;
import com.cg.lab.models.Product;

@Service
public class CartService {
	
	public Logger logger  = LoggerFactory.getLogger(CartService.class);
	@Autowired
	CartDao dao;
	
//	public Cart associateCartToCustomer(Customer customer) {
//		Cart cart = new Cart();
//		cart.setCustomer(customer);
//		return this.dao.save(cart);
//	}
//
//	
/**
 * Get Cart BY Id
 * @param cartId
 * @return
 */
	public Cart fetchCartById(Integer cartId) {
		return dao.findById(cartId).get();
	}
	
	/**
	 * Delete Product from Cart
	 * @param cartId
	 * @param productId
	 * @return
	 */
	public Cart deleteProductFromCart(Integer cartId, Integer productId) {
		Cart cart = fetchCartById(cartId);
		cart.deleteProduct(productId);
		return cart;
	}
	
	/**
	 * Add Product to Cart
	 * @param cartId
	 * @param product
	 * @return
	 */
	public Cart addProductToCart(Integer cartId,Product product) {
		Cart cart = fetchCartById(cartId);
		cart.addProduct(product);
		return this.dao.save(cart);
	}
	
	/**
	 * Create New Cart
	 * @return
	 */
	public Cart createNewCart() {
		return this.dao.save(new Cart());
	}
	
}
