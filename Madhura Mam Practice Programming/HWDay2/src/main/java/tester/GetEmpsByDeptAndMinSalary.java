package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Department;
public class GetEmpsByDeptAndMinSalary {
public static void main(String[] args) {
	try(Scanner sc=new Scanner(System.in); SessionFactory sf=getFactory();){
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		System.out.println("Enter Department name and min sal");
		dao.getEmpsByDeptAndMinSalary(
				Department.valueOf(sc.next().toUpperCase()),
				Double.parseDouble(sc.next())).forEach(System.out::println);
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
