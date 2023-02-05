package tester;

import java.time.LocalDate;
import java.util.Scanner;
import org.hibernate.*;

import dao.EmployeeDaoImpl;
import pojos.Department;
import pojos.Employee;

import static utils.HibernateUtils.getFactory;

public class AddEmpDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory session = getFactory();) {
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			System.out.println("Enter firstName, String lastName, Department dept, "
					+ "double salary, LocalDate dob, boolean isPermanent");
			Employee employee = new Employee(sc.next(), sc.next(), Department.valueOf(sc.next().toUpperCase()),
					Double.parseDouble(sc.next()), LocalDate.parse(sc.next()), sc.nextBoolean());
			System.out.println(dao.addEmpDetails(employee));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
