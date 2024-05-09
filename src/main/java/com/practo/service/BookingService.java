package com.practo.service;

import com.practo.payload.BookingDto;
import com.practo.repository.BookingRepository;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;


    public void bookingAnAppointment(BookingDto bookingDto) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        //LocalDateTime bookingTime = bookingDto.getBookingTime();
//        // Check if a booking already exists for the given date and time
//        if (bookingRepository.existsByBookingTime(bookingTime)) {
//            // Handle case when a booking already exists for the same date and time
//            throw new DuplicateBookingException("Duplicate booking detected. Booking already exists for " + bookingTime);
//        }
//
//        // Proceed with creating and saving the new booking
//        Map<String, String> bookingTimeMap = getStringLocalDateTimeMap(from, to);
//
//        for(Map.Entry<String, String>entry:bookingTimeMap.entrySet()) {
//            String key = entry.getKey();
//            String timeSlot = entry.getValue();
//            if ((bookingTime.format(formatter)).equals(timeSlot)) {
//                Booking booking = new Booking();
//                booking.setBookingTime(LocalDateTime.parse(timeSlot));
//                booking.setDoctorId(1);
//                booking.setPatientId(1);
//                bookingRepository.save(booking);
//                //bookingTimeFound = true;
//                break; // No need to continue checking other time slots
//            }
//}
//
//            // Handle case when the booking time is not found in the map
//            throw new InvalidBookingTimeException("Invalid booking time: " + bookingTime);
        }

    private static Map<String, String> getStringLocalDateTimeMap(int from, int to) {
        Map<String, String> myTimeDate = new HashMap<>();
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime tomorrowDateTime = currentDateTime.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentDateTime = currentDateTime.format(formatter);
        String formattedTomorrowDateTime = tomorrowDateTime.format(formatter);

        for (int i = from; i <= to; i++) {
            LocalDateTime todayDateTime = currentDateTime.withHour(i).withMinute(0).withSecond(0);
            String newTodayDateTime = todayDateTime.format(formatter);
            if (currentDateTime.isBefore(todayDateTime)) {
                myTimeDate.put("today" + i, newTodayDateTime);
            }
        }
        for (int i = from; i <= to; i++) {
            LocalDateTime tomorrowTimeDateTime = tomorrowDateTime.withHour(i).withMinute(0).withSecond(0);
            String newTomorrowDateTime = tomorrowTimeDateTime.format(formatter);
            if (currentDateTime.isBefore(tomorrowTimeDateTime)) {
                myTimeDate.put("tomorrow" + i, newTomorrowDateTime);
                System.out.println(myTimeDate);
            }
        }
        return myTimeDate;
    }
}

