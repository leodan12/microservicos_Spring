use examen_microservicios_2024;

create table articulo(
id int auto_increment primary key,
nombre varchar(50),
color varchar(30)
);

create table pais(
id int auto_increment primary key,
nombre varchar(50),
moneda varchar(10)
);

create table precio(
id int auto_increment primary key,
articulo_id int,
pais_id int,
valor decimal(19,4),
constraint fk_precio_pais foreign key (pais_id) references pais(id),
constraint fk_precio_articul foreign key (articulo_id) references articulo(id)
);

INSERT INTO articulo values (1,"Articulo 1", "Beige");

INSERT INTO pais values (1,"Perú", "PEN");

INSERT INTO precio values (1,1,1,34.99);