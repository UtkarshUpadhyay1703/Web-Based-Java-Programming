package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "prod_tbl")
public class Product extends BaseEntity{
	@Column(name = "product_name", length = 20)
	private String productName;
	private Double price;
	@Column(name = "manufacturing_date")
	private LocalDate manufacturingDate;
	@Column(name = "quantity")
	private int qty;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prod_cat_fk")
	private Category productCategory;

	public Product() {
		super();
	}

	public Product(String productName, Double price, LocalDate manufacturingDate, int qty) {
		super();
		this.productName = productName;
		this.price = price;
		this.manufacturingDate = manufacturingDate;
		this.qty = qty;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Product ID = "+getId()+" [productName=" + productName + ", price=" + price + ", manufacturingDate=" + manufacturingDate
				+ ", qty=" + qty + "]";
	}
	

}
