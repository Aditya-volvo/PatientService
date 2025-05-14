package com.example.patientservice.dto;

import com.example.patientservice.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequest {
    @NotBlank
    private String patientName;

    @NotBlank
    private String phone_number;

    @NotBlank
    @Email
    private String patient_email;

    @NotBlank
    private Gender gender;

    @NotBlank
    private LocalDate dateOfBirth;
}
