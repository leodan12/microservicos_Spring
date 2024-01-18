package com.nttdata.examen.pais.repository;

import com.nttdata.examen.pais.apimodel.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Integer> {
    
}
