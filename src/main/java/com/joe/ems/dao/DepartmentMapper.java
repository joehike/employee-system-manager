package com.joe.ems.dao;

import java.util.List;

import com.joe.ems.domain.Department;

public interface DepartmentMapper {

	/**
	 * 根据部门id删除部门信息
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 插入部门信息
     * @param record
     * @return
     */
    int insert(Department record);

    /**
     * 查询所有部门信息
     * @return
     */
    List<Department> select();

    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
    Department selectByPrimaryKey(Integer id);
    
    /**
     * 更新部门信息
     * @param record
     * @return
     */
    int updateByPrimaryKey(Department record);
}