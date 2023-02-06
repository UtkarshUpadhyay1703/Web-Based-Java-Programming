package com.app.dto;

public class LoginDTO {
	private String productName;
	private int qty;

	public LoginDTO(String productName, int qty) {
		super();
		this.productName = productName;
		this.qty = qty;
	}

	public LoginDTO() {
		super();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
