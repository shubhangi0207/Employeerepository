package com.employee.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.dto.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

	Optional<Employee> findByEmpid(String empId);

	Optional<Employee> deleteByempid(String empid);
}
