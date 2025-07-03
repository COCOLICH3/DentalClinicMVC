package com.dh.DentalClinicMVC.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;
    private Patient patient;
    private Dentist dentist;
    @Column(name = "date")
    private LocalDateTime date;

}
