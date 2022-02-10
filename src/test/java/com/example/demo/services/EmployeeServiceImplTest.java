package com.example.demo.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {
	
	private Employee employee;

	@Mock
	private EmployeeRepository employeeRepositoryMock;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@BeforeEach
	public void initializeEmployeeObject() {
		employee = new Employee(1, "empName", "empMail", "location");
	}
	
	@Test
	public void getEmployeeShouldReturnEmployeeById() {
		when(employeeRepositoryMock.getEmployeeById(any(Integer.class))).thenReturn(employee);
		
		int employeeId = 1;
		
		Employee actualResult = employeeService.getEmployee(employeeId);
		
		Assertions.assertEquals(employee, actualResult);
	}
}
