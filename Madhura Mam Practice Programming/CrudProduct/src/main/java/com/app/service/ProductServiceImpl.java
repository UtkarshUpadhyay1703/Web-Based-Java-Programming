package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.LoginDTO;
import com.app.pojos.Product;
import com.app.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository proRepo;

	@Override
	public List<Product> getAllProducts() {

		return proRepo.findAll();
	}

	@Override
	public Product AddProducts(Product newProduct) {
		return proRepo.save(newProduct);
	}

	@Override
	public Product loginProduct(LoginDTO prodDTO) {
		return proRepo.findByProductNameAndQty(prodDTO.getProductName(), prodDTO.getQty())
				.orElseThrow(()->new ResourceNotFoundException("invalid credentials"));
	}
	

}
