package com.employee.advice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.dto.ErrorResponse;
import com.employee.dto.response.ValidationErrorResponse;
import com.employee.dto.response.ValidationErrors;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.util.Constants;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponse> employeeNotFoundException(EmployeeNotFoundException e) {
		ErrorResponse error = new ErrorResponse(e.getMessage(), e.getStatusCode());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> validationException(MethodArgumentNotValidException e) {
//		BindingResult bindingResult = e.getBindingResult();
		ValidationErrorResponse ver = new ValidationErrorResponse();

		ver.setStatusCode(HttpStatus.BAD_REQUEST.value());
		ver.setMessage(Constants.GET_VALIDATION_MESSAGE);
		List<ValidationErrors> list = new ArrayList<>();

		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		for (FieldError er : fieldErrors) {
			ValidationErrors vr = new ValidationErrors(er.getField(), er.getRejectedValue(), er.getDefaultMessage());
			list.add(vr);
		}
		ver.setErrors(list);
		return new ResponseEntity(ver, HttpStatus.NOT_FOUND);

	}

//	public ResponseEntity<ValidationErrorResponse> validateJsonParseException(HttpMessageNotReadableException e) {
//
//		ValidationErrorResponse v = new ValidationErrorResponse();
//
//		v.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		v.setMessage(Constants.MALFORMED_ERROR_MESSAGE);
//
//		return ResponseEntity.badRequest().body(v);
//
//	}
//
//	public ResponseEntity<ValidationErrorResponse> InvalidJsonParseException(InvalidFormatException e) {
//
//		ValidationErrorResponse v = new ValidationErrorResponse();
//
//		v.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		v.setMessage(Constants.MALFORMED_ERROR_MESSAGE);
//
//		return ResponseEntity.badRequest().body(v);
//
//	}
//
//	public ResponseEntity<ValidationErrorResponse> Exception(Exception e) {
//
//		ValidationErrorResponse v = new ValidationErrorResponse();
//
//		v.setStatusCode(HttpStatus.BAD_REQUEST.value());
//		v.setMessage(Constants.MALFORMED_ERROR_MESSAGE);
//
//		return ResponseEntity.badRequest().body(v);
//
//	}

}
