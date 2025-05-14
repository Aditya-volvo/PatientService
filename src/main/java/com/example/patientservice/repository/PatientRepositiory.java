package com.example.patientservice.repository;

import com.example.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepositiory extends JpaRepository<Patient, Integer> {
    List<Patient> findAllPatients();
}
