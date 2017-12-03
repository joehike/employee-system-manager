package com.joe.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joe.ems.dao.EmployeeMapper;
import com.joe.ems.domain.Employee;

@RequestMapping("employee")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	@RequestMapping("list")
	public void list(Model model) {
		List<Employee> employees = employeeMapper.select();
		model.addAttribute("employees", employees);
	}
	
}
