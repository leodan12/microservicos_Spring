package com.nttdata.examen.pais;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaisApplication.class, args);
	}

}
