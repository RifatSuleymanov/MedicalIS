package ru.rkod.rkod.exception.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.rkod.rkod.exception.EmployeeNotFoundException;
import ru.rkod.rkod.exception.NotFoundException;
import ru.rkod.rkod.exception.model.ErrorResponse;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(final NotFoundException e) {
        return new ErrorResponse("NOT FOUND", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerRuntimeException(final RuntimeException e) {
        return new ErrorResponse("INTERNAL SERVER ERROR", e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerRuntimeException(final EmployeeNotFoundException e) {
        return new ErrorResponse("INTERNAL SERVER ERROR", e.getMessage());
    }
}