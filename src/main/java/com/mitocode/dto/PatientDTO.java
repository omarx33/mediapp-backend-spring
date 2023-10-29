package com.mitocode.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientDTO {
    @EqualsAndHashCode.Include
    private Integer idPatient;
    @NotNull
    @Size(min=3, message = "{firstName.size}")
    private String firstName;
    @NotNull
    @Size(min=3, message = "{lastname.size}")
    private String lastName;


    private String dni;
    private String address;
    private String phone;
    @Email
    private String email;
}

 /*
    @Max(value = 5)
    @Min(value = 1)
    private int edad; */
