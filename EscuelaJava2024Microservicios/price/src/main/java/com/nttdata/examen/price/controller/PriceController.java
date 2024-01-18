package com.nttdata.examen.price.controller;

import com.nttdata.examen.price.apimodel.PriceEntity;
import com.nttdata.examen.price.apimodel.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public ResponseEntity<List<PriceEntity>> getAll() {
        return ResponseEntity.ok(this.priceService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final PriceEntity countryEntity) throws Exception {
        if (countryEntity.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }
        this.priceService.saveOrUpdate(countryEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceEntity> getById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(this.priceService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final Integer id, @RequestBody final PriceEntity countryEntity) {
        countryEntity.setId(id);
        this.priceService.saveOrUpdate(countryEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Integer id) {
        this.priceService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<List<PriceEntity>>  findAllPriceByArticleId(@PathVariable Integer articuloId){
        return ResponseEntity.ok(this.priceService.findAllPricesForArticuloId(articuloId));
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<List<PriceEntity>>  findAllPriceByCountryId(@PathVariable Integer paisId){
        return ResponseEntity.ok(this.priceService.findAllPricesForCountryId(paisId));
    }





}
