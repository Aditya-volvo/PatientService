package com.example.patientservice.controller;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import com.example.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> registerPatient(@Valid @RequestBody PatientRequest patientRequest){
        return  patientService.registerPatient(patientRequest);
    }

    @GetMapping
    public List<PatientResponse> getListOfPatients(){
        return patientService.getListOfPatients();
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long patientId){
        return patientService.getPatientById(patientId);
    }

    @PutMapping("/{patientId}")
    public ResponseEntity<PatientResponse> updatePatientById(@PathVariable Long patientId, @Valid @RequestBody PatientRequest patientRequest){
        return patientService.updatePatientById(patientId,patientRequest);
    }

    @DeleteMapping("/{patientId}")
    public String deletePatientById(@PathVariable Long patientId){
        return  patientService.deletePatientById(patientId);
    }
}
