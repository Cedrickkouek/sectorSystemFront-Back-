package com.example.technicaltest.kouekamdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicaltest.kouekamdev.entities.User;
import com.example.technicaltest.kouekamdev.exceptions.SectorNotFoundException;
import com.example.technicaltest.kouekamdev.exceptions.UserNotFoundeException;
import com.example.technicaltest.kouekamdev.payloads.UserEditPayload;
import com.example.technicaltest.kouekamdev.payloads.UserPayload;
import com.example.technicaltest.kouekamdev.services.UserServices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/Users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserControllers {
    
    @Autowired
    private final UserServices userServices;

    @PostMapping(value = "/CreateUser")
    public ResponseEntity<User> CreateUser(@Valid @RequestBody UserPayload userPayload) throws SectorNotFoundException
    {
        var user = userServices.CreateUser(userPayload);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PutMapping(value = "/EditUser")
    public ResponseEntity<User> EditUser(@Valid @RequestBody UserEditPayload userEditPayload) throws SectorNotFoundException, UserNotFoundeException
    {
        var user = userServices.EditUser(userEditPayload);
        
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/DeleteUser/{userName}")
    public void DeleteUser(@Valid @PathVariable String userName)
    {
        userServices.DeleteUser(userName);
    }
}
