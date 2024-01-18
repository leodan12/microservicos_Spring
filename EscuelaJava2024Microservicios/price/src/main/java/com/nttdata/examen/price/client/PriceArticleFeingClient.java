package com.nttdata.examen.price.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "article-service" ,path = "/article")
public interface PriceArticleFeingClient {

    @GetMapping("/exists/{id}")
    Boolean findExistArticleById(@PathVariable("id") final Integer articuloId);

}
