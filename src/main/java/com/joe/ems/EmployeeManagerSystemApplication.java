package com.joe.ems;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.joe.ems.dao")
@SpringBootApplication
public class EmployeeManagerSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerSystemApplication.class, args);
	}
}
