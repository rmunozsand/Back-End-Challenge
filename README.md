# BackEnd Challenge
Desafio que consiste en el desarrollo una API RESTFul para la creación de nuevos usuarios

# Stack
![](https://img.shields.io/badge/Java_8-✓-blue.svg)
![](https://img.shields.io/badge/Maven-✓-blue.svg)
![](https://img.shields.io/badge/Spring_Boot-✓-blue.svg)
![](https://img.shields.io/badge/H2_DB-✓-blue.svg)
![](https://img.shields.io/badge/Jwt-✓-blue.svg)
![](https://img.shields.io/badge/Swagger_2-✓-blue.svg)

# Manual de funcionamiento

1. Clonar el presente repositorio
```
$ git clone https://github.com/rmunozsand/Back-End-Challenge
```

2 .Levantar el presente proyecto mediante comando de consola Maven
```
$ mvn spring-boot:run
```


**Autenticación:**

1. Acceder a la página inicial de Swagge-UI mediante localhost: http://localhost:8080/swagger-ui.html

2. Seleccionar la operación Post token para realizar la Autenticación y recibir el token de seguridad

![Alt text](docs/Swagger_token.png)

3. Presionar en botón Try it out

4. Introducir credenciales en formato Body Json, las credenciales por defecto son

```yml
{
    "username": "admin",
    "password": 123
}
```
5. Presionar botón Execute para realizar la petición del servicio

6. Copiar el token de seguridad 


**Creación de usuarios:**

1. Seleccionar la operación Post user para la creación de nuevos usuarios

![Alt text](docs/Swagger_user.png)

2. Presionar en botón Try it out

3. Introducir token de seguridad (Header) generado en el servicio anterior, anteponer el tipo de seguridad Bearer, ejemplo:

```yml
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTYzNjM5NjU3NiwiaWF0IjoxNjM1NzkxNzc2fQ.WUJ6WPfTFL6_zdhh1E97Ysx0P8pLje3qca82wXYZTBB607bkfpeEmrIzYa-v18mlWCWhxL1nXYSSsthyyYFnYA
```
4. Introducir datos del usuario en formato Body Json como se presentan en el ejemplo:

```yml
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "AAAbbbccc@123",
    "phones": [
        {
        "number": 1234567,
        "citycode": 1,
        "contrycode": 57
        }
    ]
}
```

5. Presionar botón Execute para realizar la petición del servicio

**Validación de datos:**

1. Acceder a la página inicial de H2 localhost: http://localhost:8080/h2-console

Credenciales por defecto:

    Drver class: org.h2.Driver
    JDB URL: jdbc:h2:mem:test_db
    User Name: admin
    Password: admin
![Alt text](docs/H2_login.png)

2. Realizar consultas a las tablas PHONE y USER para su validación

![Alt text](docs/H2_validacion.png)

# Diagrama de solución

![Alt text](docs/Diagrama_solucion.png)