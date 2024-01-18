package com.nttdata.examen.articulo.apimodel;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("articulo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleEntity {
    @Id
    private Integer id;

    private String nombre;

    private String color;
}
