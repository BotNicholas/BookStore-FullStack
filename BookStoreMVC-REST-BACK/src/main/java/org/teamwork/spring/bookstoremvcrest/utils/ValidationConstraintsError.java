package org.teamwork.spring.bookstoremvcrest.utils;

import jakarta.validation.ConstraintViolation;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ValidationConstraintsError {
    private String message;
    private final List<Violation> violations;

    public ValidationConstraintsError() {
        this.message = "Validation failure!";
        this.violations = new ArrayList<>();
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addViolation(ConstraintViolation<?> violation) {
        violations.add(transformViolation(violation));
    }

    public void addViolation(FieldError error) {
        violations.add(transformViolation(error));
    }

    public void addViolations(Set<ConstraintViolation<?>> violations) {
        this.violations.addAll(violations.stream().map(violation -> transformViolation(violation)).collect(Collectors.toList()));
    }

    public void addViolations(List<FieldError> errors) {
        this.violations.addAll(errors.stream().map(error -> transformViolation(error)).collect(Collectors.toList()));
    }

    private Violation transformViolation(ConstraintViolation constraintViolation) {
        Violation violation = new Violation();
        violation.setFieldName(constraintViolation.getPropertyPath().toString());
        violation.setMessage(constraintViolation.getMessage());
        return violation;
    }

    private Violation transformViolation(FieldError error) {
        Violation violation = new Violation();
        violation.setMessage(error.getDefaultMessage());
        violation.setFieldName(error.getField());
        return violation;
    }
}
