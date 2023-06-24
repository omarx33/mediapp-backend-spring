package com.mitocode.service;

import com.mitocode.model.Patient;
import com.mitocode.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


// stereotipo de sring
/*
todos funcionan igual
@Repository = para acceso a dotos
@Component = cuando no sirve en otros se usa por default
@Service = para logica de negocio
@Controller = controlador contra el cliente
 */
@Repository // esto es para enlasar a patient controller
public class PatientService {
    @Autowired // llama a @Repository de repo
   private PatientRepo repo; // = new PatientRepo();
    public String sayHello(Patient patient){
        return repo.sayHello(patient);
    }
}
