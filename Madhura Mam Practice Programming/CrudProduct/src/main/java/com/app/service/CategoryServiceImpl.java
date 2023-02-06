package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Category;
import com.app.repository.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository catRepo;

	@Override
	public List<Category> getAllCategories() {
		return catRepo.findAll();
	}

	@Override
	public Category addCategory(Category newCategory) {
		return catRepo.save(newCategory);
	}

}
