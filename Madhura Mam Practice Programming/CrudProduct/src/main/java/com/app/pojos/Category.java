package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_tbl")
public class Category extends BaseEntity {
	@Column(length = 20)
	private String name;
	@Column(length = 200)
	private String description;
	private int sales;

	@OneToMany(mappedBy = "productCategory",fetch = FetchType.EAGER)
	private List<Product> catProd =new ArrayList<Product>();

	public Category() {
		super();
	}

	public Category(String name, String description, int sales) {
		super();
		this.name = name;
		this.description = description;
		this.sales = sales;
	}

	public List<Product> getCatProd() {
		return catProd;
	}

	public void setCatProd(List<Product> catProd) {
		this.catProd = catProd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Category ID = "+getId()+" [name=" + name + ", description=" + description + ", sales=" + sales + "]";
	}
	
	
	
}
