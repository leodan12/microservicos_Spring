package com.nttdata.examen.price.apimodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("precio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceEntity {
    @Id
    private Integer id;

    private Integer articuloId;

    private Integer paisId;

    private BigDecimal valor;
}
