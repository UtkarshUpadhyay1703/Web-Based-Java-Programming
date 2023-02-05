package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.ProductDaoImpl;

public class RemoveProductFromCategory {

	public static void main(String[] args) {
		ProductDaoImpl dao = new ProductDaoImpl();

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter Category name and Product name");
			System.out.println(dao.removeProductToCategory(sc.nextLine(), sc.nextLine()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
