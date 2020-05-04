package com.cg.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cg.lab.models.Cart;
import com.cg.lab.models.Product;
import com.cg.lab.service.CartService;
import com.cg.lab.service.ProductService;

@Controller
@RequestMapping("/ProductCtrl")
public class ProductController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	private List<Product> productList;
	
	private Cart cart;
	
	//localhost:6164/ProductCtrl/getAllProducts
	@GetMapping("/getAllProducts")
	public String displayAllProducts(Model model) {
		cart = cartService.createNewCart();
		productList = productService.getAllProducts();
		model.addAttribute("products",productList);
		return "/DisplayProducts";
	}
	
	@PostMapping("/addProductToCart/{productId}")
	public String addProductToCart(@PathVariable Integer productId, Model model) {
		Product product = productList.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
		cart = cartService.addProductToCart(cart.getCartId(), product);
		model.addAttribute("products", productList);
		return "/DisplayProducts";
	}
	
	/**
	 * Use Flash Attribute to send data from one controller to another
	 * @param redirectAttributes
	 * @return
	 */
	@GetMapping("/generateBill")
	public String goToCart(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("cart", cart);
		return "redirect:/CartCtrl/cart";
	}
	
}
