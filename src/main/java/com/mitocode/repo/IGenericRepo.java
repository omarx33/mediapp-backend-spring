package com.mitocode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//el objetivo de este generico es si no desea trabajar con JpaRepository
// solo lo cambias desde aca y afecta a tods de /repo
@NoRepositoryBean
public interface IGenericRepo<T, ID> extends JpaRepository<T, ID> {
}
