package com.cg.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.lab.models.Cart;
import com.cg.lab.service.CartService;

@Controller
@RequestMapping("/CartCtrl")
public class CartController {
	
	private CartService cartService;
	
	private Cart cart;
	
	@GetMapping("/cart")
	public String DisplayCart(Model model) {
		cart = (Cart) model.getAttribute("cart");
		double totalBill = calculateBill(cart);
		model.addAttribute("totalBill",totalBill);
		model.addAttribute("cart",cart);
		return "/Cart";
	}

	private double calculateBill(Cart cart2) {
		double bill = 0;
		for(int i=0;i <cart2.getProductList().size();i++) {
			bill = bill + cart.getProductList().get(i).getProductPrice();
		}
		return bill;
	}
	
	@PostMapping("/cart/{productId}")
	public String deleteProductFromCart(Model model,@PathVariable Integer productId) {
		cart = cartService.deleteProductFromCart(cart.getCartId(), productId);
		double totalBill = calculateBill(cart);
		model.addAttribute("totalBill",totalBill);
		model.addAttribute("cart",cart);
		return "/Cart";
	}
	
	@GetMapping("goToCatalog")
	public String goToCatalog() {
		return "redirect:/ProductCtrl/getAllProducts";
	}
}
