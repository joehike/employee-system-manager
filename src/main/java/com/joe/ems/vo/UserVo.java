package com.joe.ems.vo;

import org.hibernate.validator.constraints.NotBlank;

public class UserVo {

	@NotBlank(message = "用户名不能为空")
	private String username;
	@NotBlank(message = "必须填写用户名")
	private String password;
	private String message;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
