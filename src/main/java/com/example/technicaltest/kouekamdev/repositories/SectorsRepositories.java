package com.example.technicaltest.kouekamdev.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.technicaltest.kouekamdev.entities.Sectors;

public interface SectorsRepositories extends MongoRepository<Sectors, String>{
    void deleteByValue(String value);

    boolean existsByValue(String value);
}
