package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.app.dto.LoginEmployee;
import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeSrevice {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee loginEmp(LoginEmployee empDto) {
		return empRepo.findByEmailAndPassword(empDto.getEmail(), empDto.getPassword());
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return empRepo.save(emp);
	}
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}
	
}
