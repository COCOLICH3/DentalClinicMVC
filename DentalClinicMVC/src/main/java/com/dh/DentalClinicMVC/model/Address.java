package com.dh.DentalClinicMVC.model;

import lombok.Data;

@Data
public class Address {

    private Integer id;
    private String street;
    private Integer number;
    private String location;
    private String province;
}
