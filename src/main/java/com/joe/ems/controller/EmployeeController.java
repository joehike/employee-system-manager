package com.joe.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		model.addAttribute("employee", new Employee());
		
		List<Department> departments = departmentMapper.select();
		model.addAttribute("departments", departments);
	}
	
	@RequestMapping("add")
	public String add(@Valid @ModelAttribute("employee")Employee employee,BindingResult result, Model model) {
		model.addAttribute("employee", employee);
		if(result.hasErrors()) {
			List<Department> departments = departmentMapper.select();
			model.addAttribute("departments", departments);
			return "/employee/toAdd";
		} else {
			System.out.println(employee);
			employeeMapper.insert(employee);
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
	public String edit(@Valid Employee employee, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("employee", employee);
			List<Department> departments = departmentMapper.select();
			model.addAttribute("departments", departments);
			return "/employee/toEdit";
		} else {
			employeeMapper.updateByPrimaryKey(employee);
			return "redirect:/employee/list";			
		}
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(@RequestParam("id") Integer id) {
		// 查看是否存单当前id
		if(employeeMapper.exist(id) > 0) {
			employeeMapper.deleteByPrimaryKey(id);
		}		
		return "redirect:/employee/list";
	}
	
}
