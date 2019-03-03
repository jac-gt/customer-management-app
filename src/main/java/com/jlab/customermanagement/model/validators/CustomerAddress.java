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
@Constraint(validatedBy = CustomerAddressValidator.class)
public @interface CustomerAddress {
    String message() default "Invalid Address. Address must contain a residence and a mailing address";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
