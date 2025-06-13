package com.dh.DentalClinicMVC.service;

import com.dh.DentalClinicMVC.dao.DentistDaoH2;
import com.dh.DentalClinicMVC.dao.IDao;
import com.dh.DentalClinicMVC.dao.PatientDaoH2;
import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.model.Patient;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class DentistService {

    private IDao<Dentist> dentistIDao;

    public DentistService() {
        this.dentistIDao = new DentistDaoH2();
    }

    public Dentist save(Dentist dentist) {
        return dentistIDao.save(dentist);
    }

    public Dentist findDentistById(int id) {
        return dentistIDao.findById(id);
    }

    public List<Dentist> findAllDentist() {
        return dentistIDao.findAll();
    }

    public void updateDentist(Dentist dentist) {
        dentistIDao.update(dentist);
    }

    public void deleteDentist(int id) {
        dentistIDao.delete(id);
    }

}
