package com.example.demo.repositories;

import java.util.List;

import com.example.demo.entities.Employee;

public interface EmployeeRepository {
	public Employee getEmployeeById(int Id);
	public List<Employee> getAllEmployees();
	public void saveOrUpdateEmployee(Employee employee);
	public void updateEmployee(Employee employee, int employeeId);
	public void deleteEmployee(int employeeId);
}
