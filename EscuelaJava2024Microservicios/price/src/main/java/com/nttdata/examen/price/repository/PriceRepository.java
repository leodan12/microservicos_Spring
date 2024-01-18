package com.nttdata.examen.price.repository;
import com.nttdata.examen.price.apimodel.PriceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {
    List<PriceEntity> findByArticuloId(Integer id);

    List<PriceEntity> findByPaisId(Integer id);

}
