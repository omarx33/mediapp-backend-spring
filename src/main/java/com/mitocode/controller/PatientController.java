package com.mitocode.controller;

import com.mitocode.model.Patient;
import com.mitocode.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")

public class PatientController {
     @Autowired // para traer patientService @Repository
    private PatientService service; //= new PatientService();

    @GetMapping  /* recuperar información  */
    public String sayHello(){
        Patient patient = new Patient(1,"mitocode");
        return service.sayHello(patient);
    }

}
