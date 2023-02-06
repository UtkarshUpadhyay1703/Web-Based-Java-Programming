package com.app.service;

import java.util.List;

import com.app.dto.LoginDTO;
import com.app.pojos.Product;

public interface ProductService {
	List<Product> getAllProducts();
	Product AddProducts(Product newProduct);
	Product loginProduct(LoginDTO prodDTO);
	
}
