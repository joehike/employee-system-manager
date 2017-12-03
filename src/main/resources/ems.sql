CREATE DATABASE employee_manager_system;

CREATE TABLE employee 
(
	id INT PRIMARY KEY COMMENT '主键',
	name VARCHAR(64)  NOT NULL COMMENT '姓名',
	birthday DATE COMMENT '生日',
	address CARCHAR(256) COMMENT '地址'
);