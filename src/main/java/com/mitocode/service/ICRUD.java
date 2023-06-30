package com.mitocode.service;

import com.mitocode.model.Patient;

import java.util.List;
// para tener uno central se crea la interfas ICRUD y se extiende con : extends ICRUD<Patient, Integer> ejemplo para patient
// T = clase randon, ID = PK
public interface ICRUD<T, ID> {
//con esto ya no tengo que escrubir los mismo en cada interfas, solo lo jala de aqui
    T save(T t);
    T update(T t);
    List<T> findAll();
    T findById(ID id);
    void delete(ID id);
}
