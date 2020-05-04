 package com.cg.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.lab.models.Cart;
import com.cg.lab.models.Product;
import com.cg.lab.service.CartService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api("All Cart Operations")
public class CartController {
	
	@Autowired
	CartService service;
	
	/**
	 * Create new Cart 
	 */
	
	//http://localhost:6163/cart
	@PostMapping("/cart")
	@ApiOperation("Creates a new Cart")
	public Cart newCart() {
		return service.createNewCart();
	}
	
	/**
	 * Add Product to Cart
	 * @param cartId
	 * @param product
	 * @return
	 */
	//http://localhost:6163/cart/{cartId}
	@PostMapping("/cart/{cartId}")
	@ApiOperation("Adding Product To Cart")
	public Cart addProductToCart(@PathVariable Integer cartId, @RequestBody Product product) {
		return service.addProductToCart(cartId, product);
	}
	
	/**
	 * Delete Product from Cart
	 * @param cartId
	 * @param productId
	 * @return
	 */
	//http://localhost:6163/cart/{cartId}/{productId}
	@PostMapping("/cart/{cartId}/{productId}")
	public Cart deleteProductFromCart(@ApiParam("Cart Id of Cart in which proudct will be added") @PathVariable Integer cartId,
			@ApiParam("Product which needs to be added") @PathVariable Integer productId) {
		return service.deleteProductFromCart(cartId, productId);
	}
	
	/**
	 * Fetch Cart By Id
	 * @param cartId
	 * @return
	 */ 
	//http://localhost:6163/cart/{cartId}
	@GetMapping("/cart/{cartId}")
	@ApiOperation("Fetch Cart by Cart ID")
	public Cart fetchCartById(@ApiParam("Cart Id of Cart that needs to be fetched") @PathVariable Integer cartId) {
		return service.fetchCartById(cartId);
	}

	
}
