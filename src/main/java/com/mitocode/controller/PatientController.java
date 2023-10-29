package com.mitocode.controller;

import com.mitocode.dto.PatientDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Patient;
import com.mitocode.service.iPatientService;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/patients")

public class PatientController {
    @Autowired
    private iPatientService service;

    @Autowired
    private ModelMapper mapper; //esto lo agregue en el config

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll(){

        List<PatientDTO> list = service.findAll().stream().map(p-> mapper.map(p, PatientDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id){
        Patient obj = service.findById(id);

        if (obj == null){
            throw new ModelNotFoundException("ID NO EXISTE: "+ id);
        }
        return new ResponseEntity<>(mapper.map(obj, PatientDTO.class),HttpStatus.OK);
    }
// minuto 10, video 15
//    @PostMapping
//    public ResponseEntity<Patient> save(@RequestBody Patient patient){
//        Patient obj = service.save(patient);
//        return new ResponseEntity<>(obj, HttpStatus.CREATED);
//    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PatientDTO dto){
        Patient obj = service.save(mapper.map( dto, Patient.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPatient()).toUri();
        return ResponseEntity.created(location).build();
        //esto al terminar de crea debe devolver la url del recurso creado
        // devolvera esto http://localhost:8080/patients/3
    }


    @PutMapping
    public ResponseEntity<Patient> update(@Valid @RequestBody PatientDTO dto){

        Patient obj = service.update(mapper.map( dto, Patient.class));
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
