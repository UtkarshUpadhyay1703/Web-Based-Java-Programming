package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Category;
import com.app.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService catService;

	public CategoryController() {
		super();
	}

	@GetMapping
	private List<Category> AllCategory() {
		return catService.getAllCategories();

	}

	@PostMapping
	private Category AddCategory(@RequestBody Category newCategory) {
		return catService.addCategory(newCategory);
	}
}
