package com.dh.DentalClinicMVC.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Appointment {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private LocalDateTime date;

}
