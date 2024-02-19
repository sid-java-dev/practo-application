package com.practo.service;

import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.entity.Review;
import com.practo.payload.DoctorDto;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import com.practo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public Review saveReview(Review review){
        Doctor doctor = doctorRepository.findById(review.getDoctorId()).get();
        Patient patient = patientRepository.findById(review.getPatientId()).get();
        Review savedReview=null;
        if(doctor!=null || patient!=null || review.getRating()<=5){
            savedReview = reviewRepository.save(review);
        }
        return savedReview;
    }

    public DoctorDto getReviewByDoctorId(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
        int totalCount=0;
        int countOfReviews = 0;
        for(Review review:reviews){
            totalCount +=review.getRating();
            countOfReviews++;
        }
        System.out.println(countOfReviews);
        double averageRating=(double) totalCount/countOfReviews;
        double averageRatingPercentage = (averageRating/5) * 100;
        DoctorDto dto=new DoctorDto();
        dto.setDoctor(doctor);
        dto.setReviews(reviews);
        dto.setAverageRatingPercentage(averageRatingPercentage);
        return dto;
    }
}
