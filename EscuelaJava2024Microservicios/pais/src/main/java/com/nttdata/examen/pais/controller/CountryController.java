package com.nttdata.examen.pais.controller;

import com.nttdata.examen.pais.apimodel.CountryEntity;
import com.nttdata.examen.pais.apimodel.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getAll() {
        return ResponseEntity.ok(this.countryService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final CountryEntity countryEntity) throws Exception {
        if (countryEntity.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }
        this.countryService.saveOrUpdate(countryEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryEntity> getById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(this.countryService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final Integer id, @RequestBody final CountryEntity countryEntity) {
        countryEntity.setId(id);
        this.countryService.saveOrUpdate(countryEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Integer id) {
        this.countryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable("id") final Integer id) {

        return ResponseEntity.ok(this.countryService.existsById(id));

    }

}
