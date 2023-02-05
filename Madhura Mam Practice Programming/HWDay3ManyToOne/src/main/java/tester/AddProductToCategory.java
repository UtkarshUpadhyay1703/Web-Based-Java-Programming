package tester;

import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import dao.ProductDaoImpl;
import pojos.Product;

public class AddProductToCategory {

	public static void main(String[] args) {
		ProductDaoImpl dao=new ProductDaoImpl();
		
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter first categoryName then productName, double price, String description, boolean inStock");
			System.out.println(dao.addProductToCategory(sc.nextLine(), 
					new Product(sc.nextLine(), Double.parseDouble(sc.next()), 
							sc.nextLine(), Boolean.parseBoolean(sc.next()))));//Doubt
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
