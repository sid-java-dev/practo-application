package com.practo.repository;

import com.practo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    boolean existsByBookingTime(LocalDateTime bookingTime);
}
