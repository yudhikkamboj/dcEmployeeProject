package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeService {
	public Employee getEmployee(int employeeId);
	public List<Employee> getAllEmployee();
	public void addOrUpdateEmployee(Employee employee);
	public void deleteEmployee(int employeeId);
	public void updateEmployeeDetail(int employeeId, String attribute, String value);
}
