package com.mitocode.repo;

import com.mitocode.model.Patient;
import org.springframework.stereotype.Repository;

@Repository // esto enlasa con el atuwired
public class PatientRepo {

    public String sayHello(Patient patient){
        return "hola "+ patient.getFirstName();
    }
}
