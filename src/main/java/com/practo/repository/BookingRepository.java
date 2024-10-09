package com.practo.repository;

import com.practo.entity.Booking;
import com.practo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    boolean existsByBookingTime(String bookingTime);

    @Query("SELECT b FROM Booking b JOIN b.doctor d WHERE d.id = :doctorId AND b.bookingDate = :appointmentDate AND b.bookingTime = :bookingTime")
    Optional<Booking> findBookingAvailability(@Param("doctorId") Long doctorId, @Param("appointmentDate") LocalDate appointmentDate, @Param("bookingTime") String time);
}
