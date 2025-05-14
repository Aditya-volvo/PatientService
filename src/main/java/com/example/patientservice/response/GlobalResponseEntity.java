package com.example.patientservice.response;

import com.example.patientservice.dto.PatientResponse;
import com.example.patientservice.model.Patient;
import org.springframework.http.ResponseEntity;

public class GlobalResponseEntity {
    public ResponseEntity<PatientResponse> ok(Patient patient){
        return ResponseEntity.ok(
               new  PatientResponse(
                        patient.getPatientId(),
                        patient.getPatientName(),
                        patient.getPatient_email(),
                        patient.getPhone_number(),
                        patient.getGender(),
                        patient.getDateOfBirth()

                ));
    }
}
