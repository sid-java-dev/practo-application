package com.practo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentDto {
    private long doctorId;
    private long patientId;
    private String time;
    private LocalDate date;

}
