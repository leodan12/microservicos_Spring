package com.nttdata.examen.articulo.repository;

import com.nttdata.examen.articulo.apimodel.ArticleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer> {
    
}
