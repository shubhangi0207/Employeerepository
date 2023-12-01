package com.employee.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PincodeValidator implements ConstraintValidator<Pincode, Integer> {

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {

		if (value == null) {
			return true; // null values are considered valid
		}
		if (value.SIZE == 6) {
			return true; //
		}
		String regex = "^[1-9][0-9]{5}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(String.valueOf(value));
		return matcher.matches();
	}

}
