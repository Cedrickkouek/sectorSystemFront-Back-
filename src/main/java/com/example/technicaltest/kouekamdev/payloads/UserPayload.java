package com.example.technicaltest.kouekamdev.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserPayload {
    @NotNull(message = "The name shouldn't be null")
    private String name;
    @NotNull(message = "The sector shouldn't be null")
    private String sector;
    @NotNull(message = "The agreeterms shouldn't be null")
    private boolean agreeTerms;
}
