package tester;

import static utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Departmanet;
import pojos.Employee;

public class GetEmpsByDeptAndSalary {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// Create default dao instance
			EmployeeDaoImpl empDao = new EmployeeDaoImpl();
			System.out.println("Enter dept & min Sal)");
			empDao.getEmpsByDeptAndSalary(Departmanet.valueOf(sc.next().toUpperCase()),
					sc.nextDouble()).forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
