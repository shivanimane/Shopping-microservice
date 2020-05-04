package com.cg.lab.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.lab.dao.ProductDao;
import com.cg.lab.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao dao;
	
	/**
	 * Get All Products
	 * @return
	 */
	public List<Product> getAllProducts(){
		return this.dao.findAll();
	}  
	
	/**
	 * Get Products by Category
	 * @param category
	 * @return
	 */
	public List<Product> getProductByCategory(String category){
		return dao.findAll().stream().filter(p->p.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}
	
	/**
	 * Get Product By Id
	 * @param productId
	 * @return
	 */
	public Product getProductById(Integer productId) {
		return dao.findById(productId).get();
	}

//	public Product addProduct(Product product) {
//		return dao.save(product);
//	}
}
