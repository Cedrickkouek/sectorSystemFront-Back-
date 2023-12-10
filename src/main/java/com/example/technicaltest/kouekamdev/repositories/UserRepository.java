package com.example.technicaltest.kouekamdev.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.technicaltest.kouekamdev.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
    boolean existsByName(String name);
    User findByName(String name);
    void deleteByName(String name);
}
