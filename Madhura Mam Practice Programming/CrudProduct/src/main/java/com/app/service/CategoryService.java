package com.app.service;

import java.util.List;

import com.app.pojos.Category;
import com.app.pojos.Product;

public interface CategoryService {
	List<Category> getAllCategories();

	Category addCategory(Category newCategory);
	Product addProduct(Product newProduct);
}
