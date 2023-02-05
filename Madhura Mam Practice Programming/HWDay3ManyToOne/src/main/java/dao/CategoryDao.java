package dao;

import pojos.Category;

public interface CategoryDao {
	String addNewCategory(Category newCategory);
	String removeCategory(String categoryName);
}
