package tester;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;
import pojos.Category;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class AddNewCategory {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			CategoryDaoImpl dao = new CategoryDaoImpl();
			System.out.println("Enter name and description");
			System.out.println(dao.addNewCategory(new Category(sc.nextLine(), sc.nextLine())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
