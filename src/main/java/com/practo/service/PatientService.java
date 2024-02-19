package com.practo.service;

import com.practo.entity.Patient;
import com.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Method to add a new patient
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
