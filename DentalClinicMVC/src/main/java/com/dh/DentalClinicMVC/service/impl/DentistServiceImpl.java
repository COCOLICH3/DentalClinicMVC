package com.dh.DentalClinicMVC.service.impl;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.repository.IDentistRepository;
import com.dh.DentalClinicMVC.service.IDentistService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class DentistServiceImpl implements IDentistService {

    private final IDentistRepository dentistRepository;

    @Autowired // spring se encarga de hacer los new por detras
    public DentistServiceImpl(IDentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    @Override
    public Dentist save(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Optional<Dentist> findById(Long id) {
        return dentistRepository.findById(id);
    }

    @Override
    public void update(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public void delete(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public List<Dentist> findAll() {
        return dentistRepository.findAll();
    }
}
