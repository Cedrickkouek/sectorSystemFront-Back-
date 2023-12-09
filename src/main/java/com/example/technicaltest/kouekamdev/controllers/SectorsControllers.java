package com.example.technicaltest.kouekamdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.technicaltest.kouekamdev.enumerations.Sectors;
import com.example.technicaltest.kouekamdev.services.SectorsServices;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@OpenAPIDefinition
@RequestMapping(value = "/sectors")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class SectorsControllers {
    
    @Autowired
    private SectorsServices sectorsServices;

    @PostMapping(value = "/CreateSector/{value}")
    public ResponseEntity<Sectors> CreateSector(@PathVariable String value)
    {
        Sectors sectors = sectorsServices.CreateSector(value);
        return new ResponseEntity<Sectors>(sectors, HttpStatus.CREATED);
    }

    @GetMapping(value = "/GetAllSectors")
    public ResponseEntity<List<String>> GetAllSectors()
    {
        return ResponseEntity.ok(sectorsServices.GetAllSectors());
    }
}
