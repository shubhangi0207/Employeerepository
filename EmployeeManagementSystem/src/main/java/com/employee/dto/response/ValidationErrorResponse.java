package com.employee.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationErrorResponse {

	private Integer statusCode;
	private List<ValidationErrors> errors;
	private String message;

}
