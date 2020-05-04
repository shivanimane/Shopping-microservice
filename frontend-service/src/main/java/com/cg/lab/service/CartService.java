package com.cg.lab.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.lab.models.Cart;
import com.cg.lab.models.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CartService {

	private RestTemplate restTemplate= new RestTemplate();
	
	@HystrixCommand(fallbackMethod = "fallbackForGettingCart")
	public Cart createNewCart() {
		return restTemplate.postForObject("http://localhost:6163/cart","",Cart.class);
	}
	
	@HystrixCommand(fallbackMethod = "fallbackForAddingProduct")
	public Cart addProductToCart(Integer cartId,Product product) {
		return restTemplate.postForObject("http://localhost:6163/cart/" + cartId, product, Cart.class);
	}
	
	public Cart fallbackForAddingProduct(Integer cartId,Product product) {
        // Fallback Mechanism when one microservice is down
		product.setCategory("Product Microservice is Down");
        product.setProductId(0);
        product.setProductName("Microservice is down...Please wait");
        product.setProductPrice(0);
		Cart cart = new Cart();
        cart.setCartId(0);
        cart.setProductList(Arrays.asList(product));
        return cart;
	}
	
	public Cart deleteProductFromCart(Integer cartId, Integer productId) {
		return restTemplate.postForObject("http://localhost:6163/cart/"+cartId+"/"+productId,"", Cart.class);
	}
	
	
	public Cart getCartById(Integer cartId) {
		return restTemplate.getForObject("http://localhost:6163/cart/{cartId}", Cart.class);
	}
	
	public Cart fallbackForGettingCart() {
		//Fallback method for when cart Microservice is down
		Product product = new Product();
		product.setCategory("Cart Microservice is Down");
        product.setProductId(0);
        product.setProductName("Microservice is down...Please wait");
        product.setProductPrice(0);
		Cart cart = new Cart();
        cart.setCartId(0);
        cart.setProductList(Arrays.asList(product));
        return cart;
	}
}
