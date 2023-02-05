package tester;

import org.hibernate.SessionFactory;

import dao.CategoryDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class RemoveCategory {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory(); Scanner sc=new Scanner(System.in)){
			CategoryDaoImpl dao=new CategoryDaoImpl();
			System.out.println("Enter Character name");
			System.out.println(dao.removeCategory(sc.nextLine()));
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
