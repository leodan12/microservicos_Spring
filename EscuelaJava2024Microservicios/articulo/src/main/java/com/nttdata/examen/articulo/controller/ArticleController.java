package com.nttdata.examen.articulo.controller;

import com.nttdata.examen.articulo.apimodel.ArticleEntity;
import com.nttdata.examen.articulo.apimodel.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<ArticleEntity>> getAll() {
        return ResponseEntity.ok(this.articleService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final ArticleEntity author) throws Exception {
        if (author.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo id no está permitido");
        }
        this.articleService.saveOrUpdate(author);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleEntity> getById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(this.articleService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") final Integer id, @RequestBody final ArticleEntity articleEntity) {
        articleEntity.setId(id);
        this.articleService.saveOrUpdate(articleEntity);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Integer id) {
        this.articleService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existById(@PathVariable("id") final Integer id) {
        if (id == 1) {
            throw new RuntimeException("Exceptión para probar el circuit breaker.");
        } else {
            return ResponseEntity.ok(this.articleService.existsById(id));
        }
    }

}
