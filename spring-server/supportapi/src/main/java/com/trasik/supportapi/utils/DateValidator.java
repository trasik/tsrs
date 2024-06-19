package com.trasik.supportapi.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<IsBeforeAYear, LocalDate> {

    public void initialize(IsBeforeAYear constraintAnnotation) {
    }

    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate current = LocalDate.now();
        LocalDate aYearAhead = current.plusYears(1);

        return date.isBefore(aYearAhead);
    }
}
