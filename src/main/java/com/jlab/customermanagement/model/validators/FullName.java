package com.jlab.customermanagement.model.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = FullNameValidator.class)
public @interface FullName {
    String message() default "First and last name must not be null and name fields must not be more than 200 characters";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
