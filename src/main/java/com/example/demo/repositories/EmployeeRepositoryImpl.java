package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private Map<Integer, Employee> employeeMap;

	public EmployeeRepositoryImpl() {
		this.employeeMap = new HashMap<>();
	}

	public EmployeeRepositoryImpl(Map<Integer, Employee> employeeMap) {
		this.employeeMap = employeeMap;
	}

	@Override
	public Employee getEmployeeById(int id) {
		if (employeeMap.containsKey(id)) {
			return employeeMap.get(id);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		if (employeeMap.isEmpty()) {
			return null;
		}
		return new ArrayList<>(employeeMap.values());
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		employeeMap.put(employee.getEmployeeId(), employee);
	}

	@Override
	public void updateEmployee(Employee employee, int employeeId) {
		if (employeeMap.containsKey(employeeId)) {
			employeeMap.put(employeeId, employee);
		}
	}

	@Override
	public void deleteEmployee(int employeeId) {
		if (employeeMap.containsKey(employeeId)) {
			employeeMap.remove(employeeId);
		}
	}

}
