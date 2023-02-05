package com.pojo;

public class Book {
	private int Id;
	private String Title;
	private String Author;
	private double Price;

	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Title=" + Title + ", Author=" + Author + ", Price=" + Price + "]";
	}

	public Book(int id, String title, String author, double price) {
		super();
		Id = id;
		Title = title;
		Author = author;
		Price = price;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}
}
