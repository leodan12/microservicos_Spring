package com.nttdata.examen.articulo.apimodel;

import java.util.List;

public interface ArticleService {

    List<ArticleEntity> getAll();

    void saveOrUpdate(ArticleEntity author);

    ArticleEntity getById(Integer id);

    void delete(Integer id);
    
    boolean existsById(Integer id);
}
