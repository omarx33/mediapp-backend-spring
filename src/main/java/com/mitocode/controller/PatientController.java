package com.mitocode.controller;

import com.mitocode.model.Patient;
import com.mitocode.service.iPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired
    private iPatientService service;


    @GetMapping
    public List<Patient> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable("id") Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient){
       return service.save(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient){
        return service.update(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
         service.delete(id);
    }
}
