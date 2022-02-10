package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployee(int employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}

	@Override
	public void addOrUpdateEmployee(Employee employee) {
		employeeRepository.saveOrUpdateEmployee(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteEmployee(employeeId);
	}

	@Override
	public List<Employee> getAllEmployee() {
		if (employeeRepository.getAllEmployees() == null) {
			return new ArrayList<>();
		}
		return employeeRepository.getAllEmployees();
	}
	
	@Override
	public void updateEmployeeDetail(int employeeId, String attribute, String value) throws EmployeeNotFoundException{
		
		Employee employee = employeeRepository.getEmployeeById(employeeId);
		if(employee == null) {
			throw new EmployeeNotFoundException();
		}
		
		if (attribute.equals("employeeName")) {
			employee.setEmployeeName(value);
		} else if (attribute.equals("employeeEmail")) {
			employee.setEmployeeEmail(value);
		} else {
			employee.setLocation(value);
		}
		
		employeeRepository.updateEmployee(employee, employeeId);
	}

}
