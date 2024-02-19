package com.practo.controller;

import com.practo.entity.Patient;
import com.practo.service.PatientService;
import com.practo.util.EmailService;
import com.practo.util.TwilioSmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private TwilioSmsService twilioSmsService;

    // Endpoint to add a new patient
    //http://localhost:8080/api/patients
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        Patient newPatient = patientService.addPatient(patient);
        twilioSmsService.sendSms(patient.getPhoneNumber(),"welcome to our application");
        emailService.sendRegistrationEmail(patient.getEmail(),"Welcome to Your Application", "Thank you for registering with Your Application. Welcome aboard!");
        return newPatient;
    }
}