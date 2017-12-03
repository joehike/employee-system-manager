package com.joe.ems.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joe.ems.dao.DepartmentMapper;
import com.joe.ems.dao.EmployeeMapper;
import com.joe.ems.domain.Department;
import com.joe.ems.domain.Employee;

@Controller
public class HomeController {

	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

	@RequestMapping({ "/", "index" })
	public String home(Model model) {

		return "index";
	}

	@RequestMapping("department")
	public String department(Model model) {
		// 测试部门dao层
		Department department = departmentMapper.selectByPrimaryKey(1);
		model.addAttribute("department", department);
		// 添加部门
		Department d = new Department();
		d.setId(6);
		d.setName("测试部");
		departmentMapper.insert(d);

		List<Department> departments = departmentMapper.select();
		model.addAttribute("departments", departments);

		d = departmentMapper.selectByPrimaryKey(6);
		d.setName("测试修改");
		departmentMapper.updateByPrimaryKey(d);

		// 删除
		// System.out.println(departmentMapper.deleteByPrimaryKey(6));
		return "index";
	}
	
	@RequestMapping("employee")
	public void employee() {
		Employee employee = employeeMapper.selectByPrimaryKey(1);
		System.err.println(employee);
		
		employee = new Employee();
		employee.setName("张测试");
		employee.setBirthday(new Date());
		employee.setDepartment(departmentMapper.selectByPrimaryKey(5));
		employee.setAddress("国宾");
		employeeMapper.insert(employee);
		
		
		employee = employeeMapper.selectByPrimaryKey(5);
		employee.setName("李测试");
		employeeMapper.updateByPrimaryKey(employee);
		
		
		List<Employee> employees = employeeMapper.select();
		for (Employee e : employees) {
			System.err.println(e);
		}
		
		System.err.println(employeeMapper.deleteByPrimaryKey(6));
		
		
		
	}

}
