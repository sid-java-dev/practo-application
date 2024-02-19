package com.practo.service;

import com.practo.entity.Doctor;
import com.practo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Method to add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    // Method to search for doctors by name or specializations using combined query
    public List<Doctor> searchDoctorsByNameOrSpecializations(String searchTerm) {
        return doctorRepository.searchByNameOrSpecializations(searchTerm);
    }
}

