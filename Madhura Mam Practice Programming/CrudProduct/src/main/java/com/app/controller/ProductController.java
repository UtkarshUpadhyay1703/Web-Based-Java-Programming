package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDTO;
import com.app.pojos.Product;
import com.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService prodServ;

	public ProductController() {
		super();
	}

	@GetMapping
	private List<Product> AllProducts() {
		return prodServ.getAllProducts();
	}

	@PostMapping
	private Product AddProduct(@RequestBody Product newProduct) {
		return prodServ.AddProducts(newProduct);
	}
	@PostMapping("/login")
	private Product LoginProduct(@RequestBody LoginDTO dto) {
		return prodServ.loginProduct(dto);
	}

}
