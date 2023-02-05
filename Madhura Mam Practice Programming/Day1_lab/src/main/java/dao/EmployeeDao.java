package dao;

import java.util.List;

import pojos.Departmanet;
import pojos.Employee;

public interface EmployeeDao {
//add a method to save emp details
	String addEmpDetails(Employee newEmp);
	List<Employee> getEmpsByDeptAndSalary(Departmanet dept,double minSal);
}
