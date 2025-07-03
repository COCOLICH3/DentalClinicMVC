package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.model.Dentist;

import java.util.List;
import java.util.Optional;

public interface IDentistService { // abstraccion aun mayor, desacoplar la capa de servicio del controlador usando una interfaz..

    Dentist save(Dentist dentist);
    Optional<Dentist> findById(Long id);
    void update(Dentist dentist);
    void delete(Long id);
    List<Dentist> findAll();



}
