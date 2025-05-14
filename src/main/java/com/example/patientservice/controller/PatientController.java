package com.example.patientservice.controller;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import com.example.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> registerPatient(@Valid @RequestBody PatientRequest patientRequest){
        return  patientService.registerPatient(patientRequest);
    }
}
