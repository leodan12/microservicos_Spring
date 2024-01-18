package com.nttdata.examen.pais.service;


import com.nttdata.examen.pais.apimodel.CountryEntity;
import com.nttdata.examen.pais.apimodel.CountryService;
import com.nttdata.examen.pais.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<CountryEntity> getAll() {
        final List<CountryEntity> all = new ArrayList<>();
        final Iterable<CountryEntity> Entities = this.countryRepository.findAll();
        Entities.forEach(all::add);
        return all;
    }

    public void saveOrUpdate(CountryEntity countryEntity) {
        this.countryRepository.save(countryEntity);
    }

    public CountryEntity getById(Integer id) {
        return this.countryRepository.findById(id)
                .orElse(null);
    }

    public void delete(final Integer id) {
        this.countryRepository.delete(CountryEntity.builder()
                .id(id)
                .build());
    }

    @Override
    public boolean existsById(Integer id) {

        return this.countryRepository.existsById(id);
    }
}
