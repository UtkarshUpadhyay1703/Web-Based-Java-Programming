package pojos;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
	@Column(name="product_name",length = 50,unique=true)
	private String productName;
	private double price;
	@Column(length = 200)
	private String description;
	@Column(name="in_stock")
	private boolean inStock;
	
	@ManyToOne
	private Category productCategory;

	public Product() {
		super();
	}

	public Product(String productName, double price, String description, boolean inStock) {
		super();
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.inStock = inStock;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public Category getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(Category productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product Id= "+getId()+" [productName=" + productName + ", price=" + price + ", description=" + description
				+ ", inStock=" + inStock + ", productCategory=" + productCategory + "]";
	}
	
	
}
