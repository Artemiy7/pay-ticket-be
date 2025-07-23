package com.payticket.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ValidatorUtils {
    private final Validator validator;

    public ValidatorUtils(Validator validator) {
        this.validator = validator;
    }

    public <T> List<String> validationAfterSerialization(T req) {
        if (req != null) {
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if (!result.isEmpty()) {
                return result.stream()
                        .map(constraintViolation -> constraintViolation.getPropertyPath().toString() + " " + constraintViolation.getMessage())
                        .collect(Collectors.toList());
            }
        }
        return List.of();
    }

    public <T> List<String> validationBeforeDeserialization(T req) {
        if (req != null) {
            Set<ConstraintViolation<T>> result = validator.validate(req);
            if (!result.isEmpty()) {
                return result.stream()
                        .map(constraintViolation -> constraintViolation.getPropertyPath().toString() + " " + constraintViolation.getMessage())
                        .collect(Collectors.toList());
            }
        }
        return List.of();
    }
}
