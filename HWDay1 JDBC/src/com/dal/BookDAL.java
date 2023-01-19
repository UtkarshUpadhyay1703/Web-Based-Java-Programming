package com.dal;

import java.util.List;

import com.pojo.Book;

public interface BookDAL {
	List<Book> GetAllbooks();
	int Update(Book book);
	int Add(Book book);
	int Delete(int id);
}
