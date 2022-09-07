package com.example.springaop.validator;

import com.example.springaop.dto.EmployeeDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.regex.Pattern;

public class EmployeeValidator implements ConstraintValidator<EmployeesConstraint, List<EmployeeDTO>>  {
    @Override
    public void initialize(EmployeesConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<EmployeeDTO> employees, ConstraintValidatorContext context) {
        boolean result = employees.stream()
                .anyMatch(employeeDTO ->
                     employeeDTO.getName().isEmpty() ||
                            employeeDTO.getName().length() < 10 ||
                            employeeDTO.getName().length() > 50 ||
                            employeeDTO.getEmail().isEmpty() ||
                            !Pattern.matches(com.example.springaop.constant.Pattern.EMAIL_PATTERN,
                                    employeeDTO.getEmail())

                );
        return !result;

    }

}
