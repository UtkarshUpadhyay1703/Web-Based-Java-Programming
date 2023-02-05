package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.DepartmentDao;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentDao deptDao;
	
public DepartmentController() {
	System.out.println("in def ctor "+getClass());
}
//URL: http://localhost:8080/day9_lab
@GetMapping("/")
public String getAllDepartmentNames(Model map) {
	System.out.println("in get all dept names");
	//add a line to fetch all dept names from db
	map.addAttribute("dept_names", deptDao.getAllDepartmentNames());
	return "/department/dept";//AVN : /WEB-INF/views/department/dept.jsp
}
}
