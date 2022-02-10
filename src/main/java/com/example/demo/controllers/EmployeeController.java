package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeController {

	public static final String ALL_EMPLOYEE_API_ENDPOINT = "/employees";
	public static final String EMPLOYEE_API_ENDPOINT = "/employee";
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping(ALL_EMPLOYEE_API_ENDPOINT + "/")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping(EMPLOYEE_API_ENDPOINT + "/")
	public Employee getEmployeeById(@RequestParam("empId") int employeeId) {
		return employeeService.getEmployee(employeeId);
	}
	
	@PostMapping(EMPLOYEE_API_ENDPOINT + "/")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeService.addOrUpdateEmployee(employee);
		return ResponseEntity.ok().body("Employee details added");
	}

	@DeleteMapping(EMPLOYEE_API_ENDPOINT + "/")
	public ResponseEntity<String> deleteEmployee(@RequestParam("empId") int employeeId) {
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok().body("Employee details deleted");
	}
	
	@PutMapping(EMPLOYEE_API_ENDPOINT + "/")
	public ResponseEntity<String> addEmployee(@RequestParam("empId") int employeeId,
			@RequestParam("attr") String attribute,
			@RequestParam("value") String value) {
		
		try {
			employeeService.updateEmployeeDetail(employeeId, attribute, value);
		} catch (EmployeeNotFoundException ex) {
			return ResponseEntity.badRequest().body(ex.getLocalizedMessage());
		}
		return ResponseEntity.ok().body("Employee details updated");
	}
	
}
