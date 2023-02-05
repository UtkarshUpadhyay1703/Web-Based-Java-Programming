package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	public EmployeeController() {
		System.out.println("in cons of Employee Constructor");
	}

	@GetMapping
	public List<Employee> getEmployees(){
		System.out.println("in method of employees");
		return empService.getAllEmployees();
	}
	
	
}
