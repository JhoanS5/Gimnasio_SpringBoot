# Gimnasio (Spring Boot)

## ¿Qué es este proyecto?
Este proyecto es una aplicación sencilla para gestionar un gimnasio: clientes y rutinas. Está hecha con Spring Boot y organizada en capas para que el código sea fácil de entender.

## ¿Para quién es esta guía?
Para personas que están empezando en programación y quieren ejecutar el proyecto en su máquina paso a paso.

## Requisitos (qué necesitas tener instalado)
- Java 11 o superior (JDK)
- Maven
- MySQL (o un servidor compatible) o usar una base de datos en contenedor
- Git (opcional, para clonar el repositorio)

Si no tienes Java o Maven instalados, busca "install Java 11" y "install Maven" en tu sistema operativo.

## Dependencias principales
- Spring Boot Starter Web (para crear la API REST)
- Spring Boot Starter Data JPA (para acceso a base de datos)
- MySQL Connector/J (driver para MySQL)
- springdoc-openapi / Swagger UI (documentación de la API)

## Preparar la base de datos (paso a paso)
1. Instala y arranca MySQL en tu máquina.
2. Crea una base de datos llamada `gimnasio` (puedes usar phpMyAdmin, MySQL Workbench o la consola):

```sql
CREATE DATABASE gimnasio;
```

3. Crea un archivo local `src/main/resources/application.properties` con este contenido, reemplazando los valores por los tuyos:

```
spring.datasource.url=jdbc:mysql://localhost:3306/gimnasio
spring.datasource.username=root
spring.datasource.password=<tu_password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Importante: Este archivo no se sube al repositorio (está en `.gitignore`) para proteger tus credenciales.

## Cómo ejecutar el proyecto (para principiantes)
1. Abre una terminal o PowerShell.
2. Sitúate en la carpeta del proyecto (donde está `pom.xml`). Por ejemplo:

```bash
cd C:/Users/Jhoan/Documents/zSpringBoot/SpringBoot/gimnasio
```

3. Construir el proyecto (descarga las dependencias y compila):

```bash
mvn clean package
```

Qué hace: limpia compilaciones anteriores y crea el archivo `target/...jar`.

4. Ejecutar en modo desarrollo (ver cambios rápidamente):

```bash
mvn spring-boot:run
```

Qué hace: arranca la aplicación sin crear un JAR, útil para ver logs y depurar.

5. Alternativa: ejecutar el JAR generado:

```bash
java -jar target/<artifactId>-<version>.jar
```

Reemplaza `<artifactId>-<version>.jar` por el nombre real que aparece en la carpeta `target` después de compilar.

6. Accede a la API y a la documentación:
- API: por defecto en `http://localhost:8080`
- Swagger (documentación de los endpoints): `http://localhost:8080/doc/swagger-ui.html`

## Estructura del proyecto (qué carpetas mirar)
- `src/main/java/com/campus/gimnasio/controller` → aquí están los endpoints que recibe el navegador o Postman.
- `src/main/java/com/campus/gimnasio/service` → lógica del negocio (reglas y procesos).
- `src/main/java/com/campus/gimnasio/repository` → acceso a la base de datos (JPA).
- `src/main/java/com/campus/gimnasio/entity` → las tablas/entidades que se guardan en la base de datos.
- `src/main/java/com/campus/gimnasio/dto` → objetos para recibir o enviar datos (requests/responses).

Si quieres ver cómo está hecho algo, empieza por `controller` y sigue la llamada hacia `service` y `repository`.

## Consejos para principiantes
- Si algo falla, copia el error y búscalo en Google; suele haber respuestas útiles en Stack Overflow.
- Usa Postman o Insomnia para probar los endpoints REST.
- Habilita `spring.jpa.show-sql=true` (ya está en el ejemplo) para ver las consultas SQL en la consola — ayuda a entender lo que pasa con la base de datos.

## Integrantes
- Freddy Ramon
- Manuel Galvis
- Jhoan Diaz


