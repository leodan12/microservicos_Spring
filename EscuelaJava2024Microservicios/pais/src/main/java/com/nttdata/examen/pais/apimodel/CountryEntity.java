package com.nttdata.examen.pais.apimodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("pais")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryEntity {
    @Id
    private Integer id;

    private String nombre;

    private String moneda;
}
