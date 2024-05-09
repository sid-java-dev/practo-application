package com.practo.controller;

import com.practo.payload.BookingDto;
import com.practo.payload.HomeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/my-page")
    public String myPage(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "appointment";
    }
    @PostMapping
    public ResponseEntity<String> bookingAnAppointment(@RequestBody HomeDto homeDto) {
        System.out.println(homeDto.getDate());
        System.out.println(homeDto.getTime());
        return new ResponseEntity<>("Booking is successful", HttpStatus.OK);
    }

}
