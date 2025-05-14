package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientService {
    ResponseEntity<PatientResponse> registerPatient(@Valid PatientRequest patientRequest);

    List<PatientResponse> getListOfPatients();

    ResponseEntity<PatientResponse> getPatientById(Integer patientId);

    ResponseEntity<PatientResponse> updatePatientById(Integer patientId, @Valid PatientRequest patientRequest);
}
