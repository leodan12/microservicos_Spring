package com.nttdata.examen.price.apimodel;

import java.util.List;

public interface PriceService {

    List<PriceEntity> getAll();

    void saveOrUpdate(PriceEntity author);

    PriceEntity getById(Integer id);

    void delete(Integer id);

    List<PriceEntity> findAllPricesForArticuloId(Integer articuloId);


    List<PriceEntity> findAllPricesForCountryId(Integer paisId);
}
