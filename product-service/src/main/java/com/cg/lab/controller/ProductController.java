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

//import com.cg.lab.models.Cart;
import com.cg.lab.models.Product;
import com.cg.lab.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/products")
@Api("Product related Operations")
public class ProductController {

	@Autowired
	ProductService service;

	
	
	//http://localhost:6162/products/getAllProducts
	@GetMapping("/getAllProducts")
	@ApiOperation("Fetch List of Products")
	public List<Product> getAllProducts(){
		return this.service.getAllProducts();
	}

	//http://localhost:6162/products/{productId}
	@GetMapping("/{productId}")
	@ApiOperation("Fetch Product By Id")
	public Product getProductById(@PathVariable Integer productId){
		return service.getProductById(productId);
	}
	
	//http://localhost:6162/products/category/{category}
	@GetMapping("/category/{category}")
	@ApiOperation("Fetch List of Products based on Category")
	public List<Product> getProductByCategory(@PathVariable String category){
		return service.getProductByCategory(category);
	}
	
//	@PostMapping("/addProduct")
//	public Product addProduct(@RequestBody Product product) {
//		return service.addProduct(product);
//	}
	
}
