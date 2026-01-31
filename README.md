# Gimnasio (Spring Boot)

## Descripción del proyecto
Proyecto de ejemplo para gestionar un gimnasio: clientes y rutinas. Implementado con Spring Boot y siguiendo una arquitectura por capas (controller, service, repository, entity, dto).

## Dependencias usadas
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector/J
- springdoc-openapi (Swagger UI)
- Lombok (si se usa)

## Configuración de base de datos
La configuración por defecto (no incluida en el repositorio) se coloca en `src/main/resources/application.properties`.
Ejemplo mínimo (reemplazar valores por los de su entorno):

```
spring.datasource.url=jdbc:mysql://localhost:3306/gimnasio
spring.datasource.username=<db_user>
spring.datasource.password=<db_password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

Nota: Para evitar filtrar credenciales, el archivo `src/main/resources/application.properties` se ha añadido a `.gitignore`. Cree su archivo localmente antes de ejecutar la aplicación.

## URL de Swagger
Una vez arrancada la aplicación (por defecto en el puerto 8080), la UI de Swagger estará disponible en:

http://localhost:8080/doc/swagger-ui.html

## Instrucciones para ejecutar el proyecto
1. Configurar `application.properties` local con la conexión a la base de datos.
2. Build: `mvn clean package`
3. Ejecutar en modo desarrollo: `mvn spring-boot:run`
4. Ejecutar desde JAR: `java -jar target/<artifactId>-<version>.jar`

## Estructura y arquitectura
La aplicación sigue una estructura típica por capas bajo el paquete `com.campus.gimnasio`:

- `controller` : endpoints REST
- `service` : lógica de negocio
- `repository` : interfaces JPA para persistencia
- `entity` : entidades JPA
- `dto` : objetos de transferencia (request/response)

Ejemplo de estructura (parcial):

```
src/main/java/com/campus/gimnasio/
  ├─ controller/
  ├─ service/
  ├─ repository/
  ├─ entity/
  └─ dto/
```

## Integrantes
- Freddy Ramon
- Manuel Galvis
- Jhoan Diaz

---
Si desea, puedo también:
- Ejecutar los tests (si existen)
- Push al remoto (se necesitará autenticar)
