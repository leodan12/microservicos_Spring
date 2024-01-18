package com.nttdata.examen.price.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(value = "country-service" ,path = "/country")
public interface PriceCountryFeingClient {


    @GetMapping("/exists/{id}")
    Boolean findExistCountryById(@PathVariable("id") final Integer paisId);
}
