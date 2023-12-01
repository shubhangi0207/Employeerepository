package com.employee.dto;

import javax.validation.constraints.Pattern;

import org.springframework.data.mongodb.core.mapping.Document;

import com.employee.validator.Pincode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Document
public class Address {

	@Pattern(regexp = "^[a-zA-Z0-9- ]*$", message = "Room number should contains alphabets, numeric characters or space")
	private String roomNo;

	@Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Apartment should contains alphabets, numeric characters or space")
	private String apartment;

	@Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Street should contains alphabets, numeric characters or space")
	private String street;

	@Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "City should contains alphabets, numeric characters or space ")
	private String city;

	@Pincode
	private Integer pincode;

}