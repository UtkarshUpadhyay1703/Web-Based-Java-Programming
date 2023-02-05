package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;

import static utils.HibernateUtils.getFactory;;

public class GetAllEmployees {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory();) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			dao.getAllEmployees().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
