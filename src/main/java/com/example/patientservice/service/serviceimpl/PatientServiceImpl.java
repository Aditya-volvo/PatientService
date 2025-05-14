package com.example.patientservice.service.serviceimpl;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import com.example.patientservice.exception.PatientNotFoundException;
import com.example.patientservice.mapper.GlobalMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.response.GlobalResponseEntity;
import com.example.patientservice.service.PatientService;
import com.example.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private  final PatientRepository patientRepositiory;
    private  final GlobalMapper globalMapper;
    private  final GlobalResponseEntity globalResponseEntity;

    @Override
    public ResponseEntity<PatientResponse> registerPatient(PatientRequest patientRequest) {
        Patient patient = globalMapper.mapDtoToEntity(patientRequest);
        Patient saved = patientRepositiory.save(patient);
        return globalResponseEntity.ok(saved);

    }

    @Override
    public List<PatientResponse> getListOfPatients() {
        List<Patient> patients = patientRepositiory.findAllPatients();
        return patients.stream().map(globalMapper::mapToResposeDto).toList();
    }

    @Override
    public ResponseEntity<PatientResponse> getPatientById(Long patientId) {
        Patient patient = patientRepositiory.findById(patientId)
                .orElseThrow(()-> new PatientNotFoundException("Patient By ID:"+patientId+"Not found"));
        return globalResponseEntity.ok(patient);
    }

    @Override
    public ResponseEntity<PatientResponse> updatePatientById(Long patientId, PatientRequest patientRequest) {
        Patient patient = patientRepositiory.findById(patientId)
                .orElseThrow(()-> new PatientNotFoundException("Patient By ID:"+patientId+"Not found"));
        patient.setPatientName(patientRequest.getPatientName());
        patient.setPatient_email(patientRequest.getPatient_email());
        patient.setPhone_number(patientRequest.getPhone_number());
        patient.setGender(patientRequest.getGender());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        Patient saved = patientRepositiory.save(patient);
        return  globalResponseEntity.ok(saved);
    }

    @Override
    public String deletePatientById(Long patientId) {
        Patient patient = patientRepositiory.findById(patientId)
                .orElseThrow(()-> new PatientNotFoundException("Patient By ID:"+patientId+"Not found"));
        patientRepositiory.delete(patient);
        return "The patient with id :"+patient.getPatientId()+" was deleted ";
    }
}
