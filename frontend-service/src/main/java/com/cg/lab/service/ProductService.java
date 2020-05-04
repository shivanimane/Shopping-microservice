package com.cg.lab.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.lab.models.Product;

@Service
public class ProductService {
	RestTemplate restTemplate = new RestTemplate();
	
	public List<Product> getAllProducts(){
		return Arrays.asList(restTemplate.getForEntity("http://localhost:6162/products/getAllProducts", Product[].class).getBody());
	}
	
	public List<Product> getProductsByCategory(String category) {
		return Arrays.asList(restTemplate.getForEntity("http://localhost:6162/products/"+category, Product[].class).getBody());
	}
	
	
}
