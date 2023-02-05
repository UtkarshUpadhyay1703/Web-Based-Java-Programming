package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public List<Employee> getAllEmployees(){
		return empRepository.findAll();
	}
}
