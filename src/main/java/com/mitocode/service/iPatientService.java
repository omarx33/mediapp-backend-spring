package com.mitocode.service;

import com.mitocode.model.Patient;

import java.util.List;

public interface iPatientService extends ICRUD<Patient, Integer>{
/*
    - esto es lo normal para el crud
    Patient save(Patient patient);
    Patient update(Patient patient);
    List<Patient> findAll();
    Patient findById(Integer id);
    void delete(Integer id);

    - para tener uno central se crea la interfas ICRUD y se extiende con : extends ICRUD<Patient, Integer>

 */
}
