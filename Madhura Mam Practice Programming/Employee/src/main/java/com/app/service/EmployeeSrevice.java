package com.app.service;

import java.util.List;

import com.app.dto.LoginEmployee;
import com.app.pojos.Employee;

public interface EmployeeSrevice {
	List<Employee> getAllEmployees();
	Employee loginEmp(LoginEmployee empDto);
	Employee addEmployee(Employee emp);
	void deleteEmployee(Long id);
}
