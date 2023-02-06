package com.app.service;

import java.util.List;

import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeRepository empRepo;
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
