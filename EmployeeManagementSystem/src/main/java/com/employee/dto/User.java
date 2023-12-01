package com.employee.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Document
@ApiModel(description = "User details model")
public class User {
	@Id
	@ApiModelProperty(value = "User Id", notes = "User id is unique identifier", dataType = "String")
	private String userId;

	@ApiModelProperty(value = "User Name", notes = "User Name should contain only alpha-numeric, _ and . characters")
	@Pattern(regexp = "^[a-zA-Z0-9_. ]+$", message = "User Name should contain only alpha-numeric,_ and . characters")
	@NotBlank
	@Size(min = 2, max = 50, message = "Name length should be greater than 2 and less than 50 characters")
	private String userName;

	@ApiModelProperty(value = "User password", notes = "At least one uppercase letter."
			+ "At least one lowercase letter." + "At least one digit." + "Minimum length of 8 characters.")
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$", message = "At least one uppercase letter."
			+ "At least one lowercase letter." + "At least one digit." + "Minimum length of 8 characters.")
	@Size(min = 5, max = 25, message = "User Password length should be greater than 5 and less than 25 characters")
	private String userPassword;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please Enter the valid E-mail Id")
	@Size(min = 10, max = 35, message = "Email Id length should be greater than 10 and less than 35 characters")
	private String emailId;

	@NotBlank
	@ApiModelProperty(value = "User's Mobile Number", notes = "Mobile number only contains 10 digits")
	@Pattern(regexp = "^[0-9]+$", message = "Mobile number only contains digits")
	@Size(min = 10, max = 10, message = "Mobile number should be 10 digits only")
	private String mobileNo;

	private String role;
}
