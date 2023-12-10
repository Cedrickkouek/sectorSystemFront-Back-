package com.example.technicaltest.kouekamdev.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.technicaltest.kouekamdev.entities.Sectors;
import com.example.technicaltest.kouekamdev.repositories.SectorsRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SectorsServices {
    
    @Autowired
    private final SectorsRepositories sectorsRepositories;

    public Sectors CreateSector(String val)
    {
        Sectors sectors = Sectors.builder()
        .value(val).build();

        return sectorsRepositories.save(sectors);
    }

    public List<String> GetAllSectors()
    {
        List<String> finalList = new ArrayList<>();
        var sectors = sectorsRepositories.findAll();

        for (Sectors sectors2 : sectors) {
            finalList.add(sectors2.getValue());
        }
        return finalList;
    }

    public void DeleteSector(String value)
    {
        sectorsRepositories.deleteByValue(value);
    }

}
