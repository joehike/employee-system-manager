package com.joe.ems.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.joe.ems.domain.Employee;

public interface EmployeeMapper {

	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增员工
     * @param record
     * @return
     */
    int insert(Employee record);

    /**
     * 查找所有
     * @return
     */
    List<Employee> select();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Employee selectByPrimaryKey(Integer id);

    /**
     * 根据id更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Employee record);
    
    /**
     * 是否存在当前id
     * @param id
     * @return
     */
    int exist(Integer id);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
	Employee login(@Param("name")String name, @Param("password")String password);
}