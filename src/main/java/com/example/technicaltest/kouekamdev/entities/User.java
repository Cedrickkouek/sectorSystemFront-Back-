package com.example.technicaltest.kouekamdev.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
public class User {
    private String id;
    private String name;
    private String sectors;
    private boolean agreeTerms;
}
