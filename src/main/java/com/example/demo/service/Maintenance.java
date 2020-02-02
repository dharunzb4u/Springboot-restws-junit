package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.Employee;

public interface Maintenance {
	public Employee insertDetails(String name);
	public Employee getDetails(Long id);
	public List<Employee> getAll();

}
