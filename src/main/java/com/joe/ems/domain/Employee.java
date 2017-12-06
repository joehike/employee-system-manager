package com.joe.ems.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Alias("Employee")
public class Employee {
	
	private Integer id;

	@NotEmpty(message="用户名不能为空")
	private String name;
	
	@NotNull(message="不能为空值")
	private Date birthday;

	private Department department = new Department();

	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", birthday=" + String.format("%tF", birthday) + ", department=" + department
				+ ", address=" + address + "]";
	}
}