package com.joe.ems.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("Employee")
public class Employee {
	private Integer id;

	private String name;

	private Date birthday;

	private Department department;

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