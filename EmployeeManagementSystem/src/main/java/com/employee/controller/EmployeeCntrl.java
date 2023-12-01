package com.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.Employee;
import com.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(path = "api/v1/emp")
@Log4j2
@Api(value = "Employee API", description = "This api have all the operations related to employee data")
public class EmployeeCntrl {

	@Autowired
	@Qualifier("employeeServiceImpl")
	EmployeeService employeeSvc;

	@PostMapping("/addEmployeeDetails")
	@ApiOperation(value = "Add Employee Detail API", notes = "Add Employee data to Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully added the employee details"),
			@ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<String> addEmployeeDetails(@RequestBody @Valid Employee emp) {

		log.info("Method addEmployeeDetails started.{} ", emp.toString());

		employeeSvc.addEmployeeDetails(emp);

		log.info("Employee Added successfully", emp.toString());

		return ResponseEntity.ok("Added SuccessFully ");

	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {

		log.info("Method getAllEmployees started.");

		return employeeSvc.getAllEmployees();

	}

	@GetMapping("/getEmployeeById")
	@ApiOperation(value = "Get Employee API", notes = "Get Employee Details by ID")
	public Employee getEmployeeById(
			@ApiParam(value = "ID of the Employee", required = true) @RequestParam("empId") String empId) {
		log.info("Method getEmployeeById started.");

		return employeeSvc.getEmployeeById(empId);
	}

	@PostMapping("/updateEmployeeById")
	@ApiOperation(value = "Update Employee details", notes = "Employee Id is required to update the particular employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated the employee details"),
			@ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<String> updateEmployeeById(@RequestBody Employee emp) {

		log.info("Method updateEmployeeById started.");

		employeeSvc.updateEmployeeById(emp);

		return ResponseEntity.ok("Employee with employee Id : " + emp.getEmpid() + "is updated succesfully");

	}

	@DeleteMapping("/deleteEmployeeById")
	@ApiOperation(value = "Delete employee", notes = "Employee Id is required to delete a particular employee details")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete employee successfully"),
			@ApiResponse(code = 400, message = "Bad request") })
	public ResponseEntity<String> deleteEmployeeById(
			@ApiParam(value = "Id of the employee", required = true) @RequestParam String empid) {
		log.info("deleteEmployeeById() method started");

		employeeSvc.deleteEmployeeById(empid);

		return ResponseEntity.ok("Employee with employee Id : " + empid + "is deleted succesfully");
	}

	@DeleteMapping("/deleteAllEmployees")
	@ApiResponse(code = 200, message = "Employees deleted succefully")
	public ResponseEntity<String> deleteAllEmployees() {
		log.info("deleteAllEmployees() method started");

		employeeSvc.deleteAllEmployees();

		return ResponseEntity.ok("All employee details are deleted");
	}
}
