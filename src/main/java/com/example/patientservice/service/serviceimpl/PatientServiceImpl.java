package com.example.patientservice.service.serviceimpl;

import com.example.patientservice.dto.PatientRequest;
import com.example.patientservice.dto.PatientResponse;
import com.example.patientservice.mapper.GlobalMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.response.GlobalResponseEntity;
import com.example.patientservice.service.PatientService;
import com.example.patientservice.repository.PatientRepositiory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private  final PatientRepositiory patientRepositiory;
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
}
