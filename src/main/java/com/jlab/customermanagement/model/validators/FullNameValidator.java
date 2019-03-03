package com.jlab.customermanagement.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.jlab.customermanagement.model.CustomerFullName;

@Component
public class FullNameValidator implements ConstraintValidator<FullName, CustomerFullName> {

	@Override
	public boolean isValid(CustomerFullName fullName, ConstraintValidatorContext context) {

		if (fullName == null 
				|| fullName.getFirstName() == null  || fullName.getLastName() == null
				|| fullName.getFirstName().length() > 200 
				|| fullName.getLastName().length() > 200
				|| fullName.getMiddleName().length() > 200)
			return false;

		return true;
	}

}
