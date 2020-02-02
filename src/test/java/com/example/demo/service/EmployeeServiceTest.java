package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.bean.Employee;
import com.example.demo.repository.EmployeeRepository;

public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getDetails_valid_scenario() {
		
		Employee emp = new Employee();
		emp.setId(1l);
		emp.setName("Mike");
		doReturn(Optional.of(emp)).when(employeeRepository).findById(1l);
		Employee result = employeeService.getDetails(1l);
		assertThat(result).isNotNull();
		assertThat(result.getId()).isEqualTo(emp.getId());
		assertThat(result.getName()).isEqualTo(emp.getName());	
	}
	
	@Test
	public void getDetails_throws_exception() {
		doReturn(Optional.empty()).when(employeeRepository).findById(1l);
		try {
			Employee result = employeeService.getDetails(1l);
		}
		catch(Exception e) {
			assertThat(e).isInstanceOf(EntityNotFoundException.class);
			assertThat(e.getMessage()).contains("Invalid id");
		}
	}
	
}
