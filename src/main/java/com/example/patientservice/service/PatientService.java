package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface PatientService {
    ResponseEntity<PatientResponse> registerPatient(@Valid PatientRequest patientRequest);
}
