package com.mitocode.controller;

import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Patient;
import com.mitocode.service.iPatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired
    private iPatientService service;


    @GetMapping
    public ResponseEntity<List<Patient>> findAll(){

        List<Patient> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable("id") Integer id){
        Patient obj = service.findById(id);

        if (obj == null){
            throw new ModelNotFoundException("ID NO EXISTE: "+ id);
        }
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

//    @PostMapping
//    public ResponseEntity<Patient> save(@RequestBody Patient patient){
//        Patient obj = service.save(patient);
//        return new ResponseEntity<>(obj, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Patient patient){
        Patient obj = service.save(patient);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();
        return ResponseEntity.created(location).build();
        //esto al terminar de crea debe devolver la url del recurso creado
        // devolvera esto http://localhost:8080/patients/3
    }


    @PutMapping
    public ResponseEntity<Patient> update(@RequestBody Patient patient){

        Patient obj = service.update(patient);
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
