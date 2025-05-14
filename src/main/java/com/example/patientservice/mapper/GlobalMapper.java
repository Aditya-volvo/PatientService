package com.example.patientservice.mapper;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.model.Patient;

public class GlobalMapper {
    public Patient mapDtoToEntity(PatientRequest patientRequest){
        return Patient.builder()
                .patientName(patientRequest.getPatientName())
                .patient_email(patientRequest.getPatient_email())
                .phone_number(patientRequest.getPhone_number())
                .gender(patientRequest.getGender())
                .dateOfBirth(patientRequest.getDateOfBirth())
                .build();
    }
}
