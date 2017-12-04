package com.joe.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public void toAdd(Model model) {
		List<Department> departments = departmentMapper.select();
		model.addAttribute("departments", departments);
	}
	
	@RequestMapping("add")
	public String add(@ModelAttribute("employee")Employee employee,BindingResult result, Model model) {
		model.addAttribute("employee", employee);
		if(result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getObjectName()+":"+error.getDefaultMessage());
			}
			return "add";
		} else {
			return "redirect:/employee/list";			
		}
		
		
	}
	
	@RequestMapping("toEdit")
	public void toEdit(@RequestParam("id")Integer id, Model model) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		model.addAttribute("employee", employee);
		List<Department> departments = departmentMapper.select();
		model.addAttribute("departments", departments);
	}
	
	/**
	 * 获得数据对象 使用 @ModelAttribute注解
	 * @param employee
	 * @return
	 */
	@RequestMapping("edit")
	public String edit(@ModelAttribute("employee")Employee employee) {
		employeeMapper.updateByPrimaryKey(employee);
		return "redirect:/employee/list";
	}
	
}
