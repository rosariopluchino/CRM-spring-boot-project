package com.example.myCRM.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClientModelDTO {
    @NotBlank
    String name;

    @NotBlank
    String surname;

    @NotBlank
    String email;
}
