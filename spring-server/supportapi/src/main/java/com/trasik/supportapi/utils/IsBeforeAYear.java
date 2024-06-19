package com.trasik.supportapi.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

// Custom Spring Boot Validation interface for A Year Later constraint on Due Date

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = DateValidator.class)
@Documented
public @interface IsBeforeAYear {
    // Basic Parameters needed for the annotation check
    String message() default "{message.key}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}