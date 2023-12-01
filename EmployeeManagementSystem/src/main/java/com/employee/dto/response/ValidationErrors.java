package com.employee.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrors {
	private String fieldName;
	private Object fieldValue;
	private String errorMessage;
}
