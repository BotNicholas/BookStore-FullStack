package org.teamwork.spring.bookstoremvcrest.utils;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.teamwork.spring.bookstoremvcrest.exceptions.NotFoundException;
import org.teamwork.spring.bookstoremvcrest.exceptions.UnexpectedIdException;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ExceptionHandler(UnexpectedIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public UsedIdError onUsedIdException(UnexpectedIdException e) {
        UsedIdError error = new UsedIdError();
        error.setMessage(e.getMessage());
        return error;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationConstraintsError onValidationError(ConstraintViolationException e) {
        ValidationConstraintsError error = new ValidationConstraintsError();
        error.addViolations(e.getConstraintViolations());
        error.setMessage("The object did not pass the validation! Violated constraints:");
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationConstraintsError onMethodArgumentValidationError(MethodArgumentNotValidException e) {
        ValidationConstraintsError error = new ValidationConstraintsError();
        error.addViolations(e.getBindingResult().getFieldErrors());
        error.setMessage("The object did not pass the validation! Violated constraints:");
        return error;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public NotFoundError objectNotFoundError(NotFoundException e) {
        NotFoundError error = new NotFoundError(e.getMessage());
        return error;
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public SqlIntegrityError onSqlIntegrityError(SQLIntegrityConstraintViolationException e) {
        SqlIntegrityError error = new SqlIntegrityError();
        if (e.getMessage().matches("Duplicate entry .+ for key 'users.username'")) {
            error.setMessage("Choose another username...");
        } else {
            error.setMessage(e.getMessage());
        }
        return error;
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ForbiddenError onForbiddenError(AccessDeniedException e) {
//        ForbiddenError error = new ForbiddenError();
//        error.setMessage("Oops! You can't visit this page ;-)");
//        return error;
//    }
}
