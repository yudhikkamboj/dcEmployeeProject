package com.example.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	
	@Override
	public String getMessage() {
		return "Employee not found";
	}
}
