package com.nttdata.examen.articulo.service;


import com.nttdata.examen.articulo.apimodel.ArticleEntity;
import com.nttdata.examen.articulo.apimodel.ArticleService;
import com.nttdata.examen.articulo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<ArticleEntity> getAll() {
        final List<ArticleEntity> all = new ArrayList<>();
        final Iterable<ArticleEntity> Entities = this.articleRepository.findAll();
        Entities.forEach(all::add);
        return all;
    }

    public void saveOrUpdate(ArticleEntity author) {
        this.articleRepository.save(author);
    }

    public ArticleEntity getById(Integer id) {
        return this.articleRepository.findById(id)
                .orElse(null);
    }

    public void delete(final Integer id) {
        this.articleRepository.delete(ArticleEntity.builder()
                .id(id)
                .build());
    }

    @Override
    public boolean existsById(Integer id) {
        return this.articleRepository.existsById(id);
    }
}
