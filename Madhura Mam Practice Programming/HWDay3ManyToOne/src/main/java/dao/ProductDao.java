package dao;

import pojos.Product;

public interface ProductDao {
	String addProductToCategory(String categoryName,Product product);
	String removeProductToCategory(String categoryName,String productName);
}
