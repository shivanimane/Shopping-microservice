package com.cg.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstPageController {
	
	@RequestMapping("/")
	public String firstPage() {
		return "redirect:/ProductCtrl/getAllProducts";
	}

}
