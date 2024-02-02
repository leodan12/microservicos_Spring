# Configuración global de config-server:

- Conexión a la base de datos.
- Conexión a eureka.

## Configuración de precio en config server:

- default:  
  - puerto `3061`
- develop:  
  - puerto `4061`
- prelt:  
  - puerto `5061`
- production:  
  - puerto `6061`

## Configuración de articulo en config server:

- default:
  - puerto `3062`
- develop:
  - puerto `4062`
- prelt:
  - puerto `5062`
- prepru:
  - puerto `5562`
- production:
  - puerto `6062`

## Configuración de pais en config server:
- default:
  - puerto `3063`
- develop:
  - puerto `4063`
- prepru:
  - puerto `5563`
- production:
  - puerto `6063`

## OpenApi:
`Todos los servicios deben coincidir con la especificación del openapi.`

# Microservicios:
### Global:		
  - Todos los microservicios tienen que consumirse entre ellos mediante load balancer (No gateway)
  - Ningún los microservicio debe tener en su @RestController el Request mapping "/api/v1", esto se agrega a través del gateway

  - Precio:
      - Si no existe el articulo o el pais, debe mostrar un 400 Bad Request (No importa el mensaje, con que muestre bad request está OK).
      - endpoint: 
          - `[POST]/api/v1/price`:
              - Debe consumir a articulo mediante `exists/{id}`, para validar si existe el artículo, antes de persistir la entidad precio. Usando Feign Client
              - Debe consumir a país mediante `exists/{id}`, para validar si existe el país, antes de persistir la entidad precio. Usando Feign Client
          - `[GET]/api/v1/price/article/{articleId}`:
              - Debe consumir a articulo mediante `exists/{id}`, para validar si existe el artículo, antes de consultar la base de datos. Usando Rest Template con load balancer
          - `[GET]/api/v1/price/country/{countryId}`:
               - Debe consumir a país mediante `exists/{id}`, para validar si existe el país, antes de consultar la base de datos. Usando Rest Template con load balancer

## Configuración del gateway:
 - (Todas las fechas tienen que estar con el GMT-5)
 - Puerto del gateway: 8080
 - El openapi muestra el puerto 8080, este es el puerto del gateway (8080).

 - Precio:
   - Quiero acceder a través de /api/v1/price, es decir: localhost:8080/api/v1/price
   - Quiero que para acceder al precio solo se pueda hasta las 7:45am del 2 de enero de 2024.
   - Quiero que al yo realizar alguna petición al microservicio de precio, reciba una cookie con la clave "Examen" y valor "2024"
 - Articulo:
   - Quiero que para acceder al artículo solo se pueda después las 9:37pm del 5 de febrero 2024
   - Quiero que a la respuesta se agregue el header "JavaMicro", con el valor "Examen2024"
 - Pais:
   - Quiero que para acceder al país solo se pueda entre las 2:45am del 19 de enero de 2024 y las 7:31pm del 17 de febrero 2024
   - Quiero que se quite el header "X-My-Header" del Request.
   - Quiero que se agregue un header "X-My-Header" con el valor "17012024" del Response.



