package com.dh.DentalClinicMVC.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentist_id")
    private Long id;
    @Column(name = "registration")
    private Integer registration;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;

}
