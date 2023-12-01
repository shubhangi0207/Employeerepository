package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.Employee;
import com.employee.repo.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmployeeServiceImpl2 implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void addEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		log.info("In serviceImpl2, called addEmployeeDetails method");

		// empRepo.save(emp);

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		log.info("In serviceImpl2, called getAllEmployees method");
		return null;
	}

	@Override
	public Employee getEmployeeById(String empId) {
		log.info("In serviceImpl2, called getEmployeeById method");

		return null;

	}

	@Override
	public Employee updateEmployeeById(Employee emp) {
		// TODO Auto-generated method stub

		log.info("Saved updated details of employee " + emp.toString());

		return null;
	}

	@Override
	public Employee deleteEmployeeById(String empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		log.info("Deleted all employees in the table");
	}

}
