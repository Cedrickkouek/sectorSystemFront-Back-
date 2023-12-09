package com.example.technicaltest.kouekamdev.enumerations;

import org.springframework.data.annotation.Id;
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
public class Sectors {
    @Id
    private String id;
    private String value;
}
