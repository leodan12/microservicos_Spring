package com.nttdata.examen.price.service;


import com.nttdata.examen.price.apimodel.PriceEntity;
import com.nttdata.examen.price.apimodel.PriceService;
import com.nttdata.examen.price.client.PriceArticleFeingClient;
import com.nttdata.examen.price.client.PriceCountryFeingClient;
import com.nttdata.examen.price.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private PriceArticleFeingClient priceArticleFeingClient;

    @Autowired
    private PriceCountryFeingClient priceCountryFeingClient;

    public List<PriceEntity> getAll() {
        final List<PriceEntity> all = new ArrayList<>();
        final Iterable<PriceEntity> Entities = this.priceRepository.findAll();
        Entities.forEach(all::add);
        return all;
    }

    public void saveOrUpdate(PriceEntity priceEntity) {
        //para verificar si existe el articulo
        boolean existArticle = this.priceArticleFeingClient.findExistArticleById(priceEntity.getArticuloId());
        //para verificar si existe el pais
        boolean existCountry = this.priceCountryFeingClient.findExistCountryById(priceEntity.getPaisId());

        log.info(String.valueOf("El Articulo  " + existArticle));
        log.info(String.valueOf("El Pais  " + existCountry));
        if (existArticle && existCountry) {
            this.priceRepository.save(priceEntity);
            log.info(String.valueOf("Eexists : " + existArticle));
        }

        log.info(String.valueOf("El Articulo No Existe " + existArticle));
        log.info(String.valueOf("El Pais No Existe " + existCountry));
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Id Articulo No Existe");
    }

    public PriceEntity getById(Integer id) {
        return this.priceRepository.findById(id)
                .orElse(null);
    }

    public void delete(final Integer id) {
        this.priceRepository.delete(PriceEntity.builder()
                .id(id)
                .build());
    }

    @Override
    public List<PriceEntity> findAllPricesForArticuloId(Integer articuloId) {

        List<PriceEntity> priceEntities = new ArrayList<>();
        this.priceRepository.findByArticuloId(articuloId).forEach(bstore -> priceEntities.add(bstore));
        return priceEntities;
    }

    @Override
    public List<PriceEntity> findAllPricesForCountryId(Integer paisId) {
        List<PriceEntity> priceEntities = new ArrayList<>();
        this.priceRepository.findByPaisId(paisId).forEach(bstore -> priceEntities.add(bstore));
        return priceEntities;
    }


}
