package com.employee.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Document
@ApiModel(description = "Details about employee")
public class Employee {

	@Id
	@ApiModelProperty(value = "Employee Id", notes = "Employee id is unique identifier", dataType = "String")
	private String empid;

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Name should only contain alphabetic characters")
	@NotBlank(message = "Employee Name is required")
	@Size(min = 2, max = 50, message = "Name length should be greater than 2 and less than 50 char")
	private String name;

	@NotNull(message = "Employee Age is required")
	@Positive
	private Integer age;

	@NotNull
	@Positive
	private Double salary;

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Designation only contain alphabetic characters")
	@Size(min = 2, max = 35, message = "Designation length should be greater than 2 and less than 35 char")
	private String designation;

	@Pattern(regexp = "^[a-zA-Z0-9.,]+$", message = "Role contain alphabetic,numeric or special characters")
	@Size(min = 2, max = 35, message = "Role length should be greater than 2 and less than 50 char")
	private String role;

	@Pattern(regexp = "^[a-zA-Z ]+$", message = "Department should only contain alphabetic characters")
	@NotBlank
	@Size(min = 2, max = 20, message = "Department length should be greater than 2 and less than 20 char")
	private String department;

	@Valid
	private Address address;

}
