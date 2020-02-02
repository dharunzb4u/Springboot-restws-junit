package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {

	
	@Id
	@GeneratedValue
	@Column(name= "employee_id")
	private Long id;
	@Column(name="employee_name")
	private String name;
	@Column(name="employee_dept")
	public final String dept = "IT dept";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDept() {
		return dept;
	}
	
	


}
