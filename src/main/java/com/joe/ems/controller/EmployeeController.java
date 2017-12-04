package com.joe.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joe.ems.dao.DepartmentMapper;
import com.joe.ems.dao.EmployeeMapper;
import com.joe.ems.domain.Department;
import com.joe.ems.domain.Employee;

@RequestMapping("employee")
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@RequestMapping("list")
	public void list(Model model) {
		List<Employee> employees = employeeMapper.select();
		model.addAttribute("employees", employees);
	}
	
	@RequestMapping("toAdd")
	public void toAdd() {
	}
	
	@RequestMapping("toEdit")
	public void toEdit(@RequestParam("id")Integer id, Model model) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		List<Department> departments = departmentMapper.select();
		model.addAttribute("departments", departments);
	}
	
}
