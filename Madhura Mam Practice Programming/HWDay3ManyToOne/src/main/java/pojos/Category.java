package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="category")
public class Category extends BaseEntity{
	@Column(name="category_name",length = 50,unique = true)
	private String categoryName;
	@Column(length = 200)
	private String description;
	
	//@OneToMany//Giving the information to hibernate of one to many only so it will create one more table
	//So we use mappedBy so it will stop from creating new table name=productCategory_id
	//We set cascade all so that we can do any method
	@OneToMany(mappedBy = "productCategory",cascade=CascadeType.ALL)
	private List<Product> products=new ArrayList<Product>();///initilise to empty list

	public Category() {
		super();
	}
	

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}


	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category Id = "+getId()+" [categoryName=" + categoryName + ", description=" + description + ", products=" + products
				+ "]";
	}
	//we can write this all functions inside any class but the king shared that it is easy if 
	//
	public void addProduct(Product p) {
		//for parent to child connectivity
		products.add(p);
		//for child to parent connectivity
		p.setProductCategory(this);
	}
	public void removeProduct(Product p) {
		for(Product k:products) {
			System.out.println(k);
		}
		products.remove(p);
	}
	
}
