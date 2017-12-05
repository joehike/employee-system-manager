package com.joe.ems.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joe.ems.dao.EmployeeMapper;
import com.joe.ems.domain.Employee;
import com.joe.ems.vo.UserVo;

@Controller
public class AuthorizeController {

	@Autowired
	private EmployeeMapper mapper;
	
	@RequestMapping( path="/login", method=RequestMethod.GET)
	public String toLogin(Model model) {
		model.addAttribute("userVo", new UserVo());
		return "login";
	}

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String login(@Valid UserVo user, BindingResult result, HttpSession httpSession, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("userVo", user);
			return "login";
		}

		Employee employee = mapper.login(user.getUsername(), user.getPassword());
		if (employee != null) {
			httpSession.setAttribute("employee", employee);
			return "redirect:/employee/list";
		}
		model.addAttribute("userVo", user);
		// 全局错误 使用 global获得
		result.reject("登录失败", "用户名或密码错误");
		//result.rejectValue("message", "登录失败", "用户名或密码错误");
		
		return "login";

	}

}
