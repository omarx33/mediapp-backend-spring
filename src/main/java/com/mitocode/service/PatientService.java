package com.mitocode.service;


import com.mitocode.model.Patient;
import com.mitocode.repo.iPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// stereotipo de spring
/*
todos funcionan igual
@Repository = para acceso a dotos
@Component = cuando no sirve en otros se usa por default
@Service = para logica de negocio
@Controller = controlador contra el cliente
 */
@Service

public class PatientService implements iPatientService {

    @Autowired
    private iPatientRepo repo;
    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public Patient findById(Integer id) {
       // Optional<Patient> op = repo.findById(id);
      //  return op.isPresent() ? op.get() : new Patient();
        //si la consulta esta vacia no devuelva valor
       // return op.orElse(new Patient());
        return repo.findById(id).orElse(new Patient());
    }

    @Override
    public void delete(Integer id) {
    repo.deleteById(id);
    }
}
