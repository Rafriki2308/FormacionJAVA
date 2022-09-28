package com.bosonit.Ej7.crudvalidation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ExeptionManager {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> methodEntityNotFoundException(HttpServletRequest request, EntityNotFoundException e) {
        CustomError customErrorInfo = new CustomError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(customErrorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<CustomError> methodUnprocessableEntityException(HttpServletRequest request, UnprocessableEntityException e) {
        CustomError customErrorInfo = new CustomError(HttpStatus.UNPROCESSABLE_ENTITY.value(), e.getMessage());
        return new ResponseEntity<>(customErrorInfo, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
