package com.cg.lab.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.lab.models.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer>{

}
