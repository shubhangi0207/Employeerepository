package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.employee.dto.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repo.EmployeeRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Override
	public void addEmployeeDetails(Employee emp) {
		// TODO Auto-generated method stub
		log.info("In serviceImpl, called addEmployeeDetails method");

		empRepo.save(emp);

	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		log.info("In serviceImpl, called getAllEmployees method");
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(String empId) {

		return empRepo.findByEmpid(empId).orElseThrow(
				() -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND.value(), "Employee Id is Not present In DB"));

	}

	@Override
	public Employee updateEmployeeById(Employee emp) {
		// TODO Auto-generated method stub

		Employee e1 = empRepo.findByEmpid(emp.getEmpid()).orElseThrow(
				() -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND.value(), "Employee Id is not present In DB"));

		log.info("Get employee details by Id" + e1.toString());

		e1.setName(emp.getName());
		e1.setAge(emp.getAge());
		e1.setSalary(emp.getSalary());
		e1.setRole(emp.getRole());
		e1.setDesignation(emp.getDesignation());
		e1.setDepartment(emp.getDepartment());
		e1.getAddress().setRoomNo(emp.getAddress().getRoomNo());
		e1.getAddress().setApartment(emp.getAddress().getApartment());
		e1.getAddress().setCity(emp.getAddress().getCity());
		e1.getAddress().setPincode(emp.getAddress().getPincode());
		e1.getAddress().setStreet(emp.getAddress().getStreet());

		log.info("Saved updated details of employee " + emp.toString());

		return empRepo.save(e1);
	}

	@Override
	public Employee deleteEmployeeById(String empid) {
		// TODO Auto-generated method stub

		return empRepo.deleteByempid(empid).orElseThrow(
				() -> new EmployeeNotFoundException(HttpStatus.NOT_FOUND.value(), "Employee Id Not present in db"));
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub

		empRepo.deleteAll();

		log.info("Deleted all employees in the table");
	}

}
