package com.cg.lab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lab.models.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
