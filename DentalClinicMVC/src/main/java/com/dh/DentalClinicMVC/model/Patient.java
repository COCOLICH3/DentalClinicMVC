package com.dh.DentalClinicMVC.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Patient {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private Integer cardIdentity;
    private LocalDate admissionOfDate;
    private Address address;


}
