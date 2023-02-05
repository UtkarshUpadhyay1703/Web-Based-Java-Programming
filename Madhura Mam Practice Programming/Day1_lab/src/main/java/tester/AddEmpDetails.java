package tester;
import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Departmanet;
import pojos.Employee;

public class AddEmpDetails {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();Scanner sc=new Scanner(System.in) ){
			//Create default dao instance
			EmployeeDaoImpl empDao=new EmployeeDaoImpl();
			System.out.println("String firstName, "
					+ "String lastName, Departmanet dept, LocalDate dob, boolean isPermanent");
			//create transient emp
			Employee emp=new Employee(sc.next(),sc.next(), Departmanet.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()), sc.nextBoolean(),sc.nextDouble());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
