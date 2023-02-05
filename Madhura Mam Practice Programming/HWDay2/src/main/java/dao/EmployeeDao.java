package dao;

import java.util.List;

import pojos.Department;
import pojos.Employee;

public interface EmployeeDao {
	List<Employee> getEmpsByDeptAndMinSalary(Department dept,double minSal);
	List<Employee> getAllEmployees();
	String addEmpDetails(Employee emp);
}
