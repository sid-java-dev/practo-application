package com.practo.controller;

import com.practo.entity.Doctor;
import com.practo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Endpoint to add a new doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.addDoctor(doctor), HttpStatus.CREATED);
    }

//http://localhost:8080/api/doctors/search?searchTerm=Dr. Michael Johnson
    @GetMapping("/search")
    public List<Doctor> searchDoctors(@RequestParam String searchTerm) {
        if (searchTerm != null) {
            return doctorService.searchDoctorsByNameOrSpecializations(searchTerm);
        } else {
            // Handle invalid or missing parameters
            throw new IllegalArgumentException("Please provide a 'searchTerm' parameter.");
        }
    }
}
