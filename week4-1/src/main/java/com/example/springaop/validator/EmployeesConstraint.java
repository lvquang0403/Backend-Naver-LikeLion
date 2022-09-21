package com.example.springaop.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = EmployeeValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmployeesConstraint {
    String message() default "Invalid Employees data";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
