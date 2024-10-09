package com.practo.controller;

import com.practo.entity.Booking;
import com.practo.payload.AppointmentDto;
import com.practo.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("httP://localhost:4200")
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @PostMapping
    public ResponseEntity<Booking>createBooking(@RequestBody AppointmentDto appointmentDto){
        Booking booking = appointmentService.createBooking(appointmentDto);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
}
