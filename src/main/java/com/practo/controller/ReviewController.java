package com.practo.controller;

import com.practo.entity.Review;
import com.practo.payload.DoctorDto;
import com.practo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody  Review review){
        return new ResponseEntity<>(reviewService.saveReview(review), HttpStatus.CREATED);
    }

    @GetMapping
    public DoctorDto getReviewByPostId(@RequestParam long doctorId){
        DoctorDto dto=reviewService.getReviewByDoctorId(doctorId);
        return dto;
    }


}
