package com.practo.controller;


import com.practo.payload.BookingDto;
import com.practo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookingAnAppointment(@RequestBody BookingDto bookingDto) {
        bookingService.bookingAnAppointment(bookingDto);
        return new ResponseEntity<>("Booking is successful", HttpStatus.OK);
    }

}
