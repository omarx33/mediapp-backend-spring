package com.mitocode.service.impl;


import com.mitocode.model.Medic;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.iMedicRepo;
import com.mitocode.service.iMedicService;
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

public class MedicServiceImpl extends CRUDImpl<Medic, Integer> implements iMedicService {

    @Autowired
    private iMedicRepo repo;

    @Override
    protected IGenericRepo<Medic, Integer> getRepo() {
        return repo;
    }
}
