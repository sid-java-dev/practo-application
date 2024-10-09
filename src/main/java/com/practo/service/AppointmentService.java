package com.practo.service;

import com.practo.entity.Booking;
import com.practo.entity.BookingTime;
import com.practo.entity.Doctor;
import com.practo.entity.Patient;
import com.practo.payload.AppointmentDto;
import com.practo.payload.BookingException;
import com.practo.repository.BookingRepository;
import com.practo.repository.DoctorRepository;
import com.practo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private BookingRepository bookingRepository;

    public AppointmentService(DoctorRepository doctorRepository, PatientRepository patientRepository, BookingRepository bookingRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(AppointmentDto appointmentDto) {
        Doctor doctor = doctorRepository.findById(appointmentDto.getDoctorId()).get();
        Patient patient = patientRepository.findById(appointmentDto.getPatientId()).get();
        if (doctor != null && patient != null) {
            LocalDate appointmentDate = appointmentDto.getDate();
            LocalDate currentDate = LocalDate.now();
            if (appointmentDate.isBefore(currentDate)) {
                throw new BookingException("please select valid date");
            }
            String time = appointmentDto.getTime();
            boolean validatedTimeSlot = validateTimeSlot(time);

            if (validatedTimeSlot) {
                Optional<Booking> optionalBooking = bookingRepository.findBookingAvailability(doctor.getId(), appointmentDate, time);
                if (optionalBooking.isEmpty()) {
                    Booking b = new Booking();
                    b.setDoctor(doctor);
                    b.setPatient(patient);
                    b.setBookingDate(appointmentDate);
                    b.setBookingTime(time);
                    return bookingRepository.save(b);

                } else {
                    throw new BookingException("Booking is already Done for this slot");
                }

            }

        }
        return null;
    }

    private boolean validateTimeSlot(String time) {
        List<String> allTimeSlots = BookingTime.getAllTimeSolts();
        for (String timeSlot : allTimeSlots) {
            if (time.equals(timeSlot)) {
                return true;
            }
        }
        return false;
    }
}
