package com.employee.exception;

import lombok.Getter;

@Getter
public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String message;

	public EmployeeNotFoundException(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

}
