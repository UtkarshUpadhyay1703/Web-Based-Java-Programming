package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.EmployeeResponse;
import com.app.dto.LoginRequestDto;
import com.app.pojos.Employee;
import com.app.service.EmployeeService;

//@ResponseBody tells a controller that the object returned is automatically
//serialized into JSON and passed back into the HttpResponse object.

@RestController

//To enable CORS header 
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
//dep : service layer i.f
	@Autowired
	private EmployeeService empService;

	public EmployeeController() {
		System.out.println("in def ctor " + getClass());
	}

//add REST end point to get all emps
	// http:host:port/employees , method=GET
	@GetMapping
	public List<Employee> getAllEmps() {
		System.out.println("in get all emps");
		return empService.getAllEmpDetails();
	}// Handler rets @RespBody List --> D.S (SC) --> SC performs marshalling(java
		// ---> JSON) --> sent to front end
		// add REST end point to add new emp details
		// http:host:port/employees , method=POST

	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee transientEmp) {
		System.out.println("in save emp " + transientEmp + " id " + transientEmp.getId());//
		return empService.addEmpDetails(transientEmp);

	}

	// http:host:port/employees/123 , method=DELATE
	@DeleteMapping("/{empId}")
	public ApiResponse deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del emp " + empId);
		return new ApiResponse(empService.deleteEmpDetails(empId));
	}

	// http:host:port/employees/123 , method=GET
	@GetMapping("/{empId}")
	public Employee getEmpDetails(@PathVariable Long empId) {
		System.out.println("in get emp details " + empId);
		// invoke service layer method to get emp details
		return empService.fetchEmpDetails(empId);
	}

	// http:host:port/employees , method=PUT
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp) {
// HttpRequest body to a transfer or domain object, enabling automatic
// deserialization of the inbound HttpRequest body onto a Java object
		System.out.println("in update emp " + detachedEmp.getId());// not null
		return empService.updateEmpDetails(detachedEmp);
	}

	// Add REST end point for Emp siginin
	@PostMapping("/signin")
	public Employee validateEmployee(@RequestBody LoginRequestDto dto) {
		System.out.println("in emp signin " + dto);
		return empService.authenticateEmp(dto);
	}

	// Add REST end point for searching emps by dept n date
	// http://host:port/employees/date/2020-1-1/dept/rnd , method =GET
	@GetMapping("/date/{joinDate1}/dept/{dept1}")
	public List<Employee> getAllEmpsByDateAndDept(
			@PathVariable @DateTimeFormat(pattern = "yyyy-M-d") LocalDate joinDate1, @PathVariable String dept1) {
		System.out.println("in get all emps by date n dept " + joinDate1 + " " + dept1);
		return empService.getEmpsByDateAndDept(joinDate1, dept1);
	}

	// Add REST end point for searching emps by sal range , method = GET
	// pass payload as req params
	@GetMapping("/salary")
	public List<EmployeeResponse> getAllEmpsBySalaryRange(@RequestParam double minSal, double maxSal) {
		// @RequestParam is used to read the HTML form data provided by a user and bind
		// it to the request parameter
		System.out.println("in get emps by sal " + minSal + " " + maxSal);
		return empService.getEmpsBySalary(minSal, maxSal);
	}

}
