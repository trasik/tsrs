package com.trasik.supportapi.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

// Validation class to be used with the IsBeforeAYear interface
public class DateValidator implements ConstraintValidator<IsBeforeAYear, LocalDate> {

    // Since we have no custom parameter, nothing to do in initialize method
    public void initialize(IsBeforeAYear constraintAnnotation) {
    }

    // Basic Check: Get current date, Add a year to it, then return if the given due date is before that year ahead date
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate current = LocalDate.now();
        LocalDate aYearAhead = current.plusYears(1);

        return date.isBefore(aYearAhead);
    }
}
