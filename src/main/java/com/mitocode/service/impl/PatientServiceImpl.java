package com.mitocode.service.impl;


import com.mitocode.model.Patient;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.iPatientRepo;
import com.mitocode.service.iPatientService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


// stereotipo de spring
/*
todos funcionan igual
@Repository = para acceso a dotos
@Component = cuando no sirve en otros se usa por default
@Service = para logica de negocio
@Controller = controlador contra el cliente
 */
@Service

public  class PatientServiceImpl extends CRUDImpl<Patient, Integer> implements iPatientService {

    @Autowired
    private iPatientRepo repo;

    @Override
    protected IGenericRepo<Patient, Integer> getRepo() {
        return repo;
    }
    // esto es solo para separar y tener algo generico para cruds,
    // si ay alguna consulta o query diferente se debe generar aqui con la misma estructura comentada abajo
    /*
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

     */
}
