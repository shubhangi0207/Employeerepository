package com.employee.service;

import java.util.List;

import com.employee.dto.Employee;

public interface EmployeeService {

	public void addEmployeeDetails(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmployeeById(String empId);

	public Employee updateEmployeeById(Employee emp);

	public Employee deleteEmployeeById(String empid);

	public void deleteAllEmployees();

}
