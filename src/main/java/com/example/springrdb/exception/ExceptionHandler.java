package com.example.springrdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errMap = new HashMap<>();
        ex.getFieldErrors().forEach(e -> {
            errMap.put(e.getField(), e.getDefaultMessage());
        });

        return errMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @org.springframework.web.bind.annotation.ExceptionHandler(NoFoundException.class)
    public Map<String, String> handleNoFoundException(NoFoundException ex) {
        Map<String, String> errMap = new HashMap<>();
        errMap.put("errorMessage", ex.getMessage());

        return errMap;
    }
}
