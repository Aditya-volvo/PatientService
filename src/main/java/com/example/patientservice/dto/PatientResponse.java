package com.example.patientservice.dto;

import com.example.patientservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponse {
    private int patientId;
    private String patientName;
    private String phone_number;
    private String patient_email;
    private Gender gender;
    private LocalDate dateOfBirth;
}
