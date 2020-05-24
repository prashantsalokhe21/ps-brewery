package com.prashant21tube.psbrewery.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: ps-brewery
 * Package: com.prashant21tube.psbrewery.exception
 * <p>
 * User: lenovo
 * Date: 5/24/2020
 * Time: 9:16 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e) {
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());

        e.getConstraintViolations().forEach(constraintViolation ->
        {
            errors.add(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<List> notFountGlobal(Exception e){

        System.out.println("----------CaughtApplicationException-----------");
        return new ResponseEntity<>(e.getMessage().lines().collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }
}
