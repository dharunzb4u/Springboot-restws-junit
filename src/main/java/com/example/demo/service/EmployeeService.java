package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService implements Maintenance {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployee() {
		return employeeRepository.findAll().iterator().next();
		
	}

	@Override
	public Employee insertDetails(String name) {
		Employee emp = new Employee();
		emp.setName(name);
		employeeRepository.save(emp);
		return emp;
	}

	@Override
	public Employee getDetails(Long id) {
		Optional<Employee> emp =  employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		throw new EntityNotFoundException("Invalid id");
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emplist = new ArrayList<>();
		employeeRepository.findAll().forEach(emplist::add);
	
		
		return emplist;
		
	}

}
