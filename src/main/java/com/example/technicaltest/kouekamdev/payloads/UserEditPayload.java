package com.example.technicaltest.kouekamdev.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserEditPayload {
    @NotNull(message = "The name shouldn't be null")
    private String oldName;
    private String newName;
    private String sector;
}
