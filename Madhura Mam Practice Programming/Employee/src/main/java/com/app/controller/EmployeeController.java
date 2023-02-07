package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginEmployee;
import com.app.pojos.Employee;
import com.app.service.EmployeeSrevice;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeSrevice empSer;

	@GetMapping
	public List<Employee> getEmployees() {
		return empSer.getAllEmployees();
	}
	@PostMapping("/Login")
	public Employee loginEmployee(@RequestBody LoginEmployee empLogin) {
		return empSer.loginEmp(empLogin);
	}
	@PostMapping
	public Employee addEmployee(@RequestBody Employee emp) {
		return empSer.addEmployee(emp);
	}
	@DeleteMapping("/{empid}")
	public void deleteEmployee(@PathVariable Long empid) {
		empSer.deleteEmployee(empid);
	}
	@PutMapping
	public Employee updateEmployees(@RequestBody Employee emp) {
		return empSer.updateEmployee(emp);
	}
}
