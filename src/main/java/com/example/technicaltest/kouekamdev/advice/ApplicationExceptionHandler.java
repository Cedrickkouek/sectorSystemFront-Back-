package com.example.technicaltest.kouekamdev.advice;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.technicaltest.kouekamdev.exceptions.SectorNotFoundException;
import com.example.technicaltest.kouekamdev.exceptions.UserNotFoundeException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SectorNotFoundException.class)
    public Map<String, String> SectorsExceptionHandler(SectorNotFoundException excep)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Message D'erreur", excep.getMessage());
        return errorMap;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFoundeException.class)
    public Map<String, String> UserNotFoundeException(UserNotFoundeException excep)
    {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("Message D'erreur", excep.getMessage());
        return errorMap;
    }

}
