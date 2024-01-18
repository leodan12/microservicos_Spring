package com.nttdata.examen.pais.apimodel;

import java.util.List;

public interface CountryService {

    List<CountryEntity> getAll();

    void saveOrUpdate(CountryEntity author);

    CountryEntity getById(Integer id);

    void delete(Integer id);
    
    boolean existsById(Integer id);
}
