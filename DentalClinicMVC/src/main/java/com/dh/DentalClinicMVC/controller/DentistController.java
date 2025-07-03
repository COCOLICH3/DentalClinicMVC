package com.dh.DentalClinicMVC.controller;

import com.dh.DentalClinicMVC.model.Dentist;
import com.dh.DentalClinicMVC.service.IDentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class DentistController {

    private IDentistService iDentistService;

    @Autowired
    public DentistController(IDentistService iDentistService) {
        this.iDentistService = iDentistService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> findById(@PathVariable Long id) {
        Optional<Dentist> dentist = iDentistService.findById(id);
                if(dentist.isPresent()){
                    return ResponseEntity.ok(dentist.get());
                }else{
                    return ResponseEntity.notFound().build();
                }
    }

    @PostMapping
    public  ResponseEntity<Dentist> createDentist(@RequestBody Dentist dentist) {
        return ResponseEntity.ok(iDentistService.save(dentist));
    }

    @PutMapping
    public ResponseEntity<String>  updateDentist(@RequestBody Dentist dentist) {
        ResponseEntity<String> response;
        Optional<Dentist> dentistToLookFor = iDentistService.findById(dentist.getId());
        if(dentistToLookFor.isPresent()){
            iDentistService.update(dentist);
            response = ResponseEntity.ok("Se actualizo el odontolog con nombre" + dentist.getName());
        }else{
            response = ResponseEntity.ok().body("No se puede actualizar");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteDentist(@PathVariable Long id) {
        ResponseEntity<String> response;
        Optional<Dentist> dentist = iDentistService.findById(id);

        if(dentist.isPresent()){
            iDentistService.delete(id);
            response=ResponseEntity.ok("Se elimino el odontologo con id: " + id);
        }else{
            response=ResponseEntity.ok("No se pudo eliminar el odontologo con id: " + id);
        }
        iDentistService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<Dentist>> findAll() {
       return ResponseEntity.ok(iDentistService.findAll());
    }
}
