package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	EmployeeService employeeService;
	EmployeeRepository employeeRepository;

	//Constructor Injection instead of autowired
	public EmployeeController(EmployeeService employeeService,EmployeeRepository employeeRepository) {
		this.employeeService = employeeService;
		this.employeeRepository = employeeRepository;
	}

	@GetMapping(value= "/getOne/{id}")
	public Employee getName(@PathVariable("id") Long id) {
		return employeeService.getDetails(id);
		
	}
	
	@GetMapping(value= "/getAll")
	public List<Employee> getAll() {
	return employeeService.getAll();
}
	@PutMapping(value= "/insert/")
	public Employee saveData(@PathVariable("name") String name) {
		return employeeService.insertDetails(name);
		
	}
}
