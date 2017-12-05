package com.joe.ems.domain;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

@Alias("Department")
public class Department {
	@NotNull
    private Integer id = 1;

    private String name;

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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
    
}