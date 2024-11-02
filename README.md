# Visão geral

O projeto é uma aplicação back-end com objetivo de criar um sistema de autoatendimento de fast food, que é composto por uma série de dispositivos e interfaces que permitem aos clientes selecionar e fazer pedidos sem precisar interagir com um atendente. Está sendo utilizado neste projeto as seguintes tecnologias [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data). 

## Tecnologias

- **Spring Boot**: Framework para construção de aplicações Java.
    - `spring-boot-starter-web`: Para construir aplicações web.
    - `spring-boot-starter-data-jpa`: Para integração com JPA (Java Persistence API).
    - `spring-boot-starter-validation`: Para validação de dados.
- **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
- **Lombok**: Biblioteca para reduzir o código boilerplate.
- **MapStruct e ModelMapper**: Para mapeamento de objetos.
- **Flyway**: Para gerenciamento de migrações de banco de dados.
- **Spring Cloud OpenFeign**: Para facilitar chamadas de serviços REST.
- **Springdoc OpenAPI**: Para gerar documentação da API.

## Requisitos

- Java 21
- Docker e Docker Compose

## Estrutura do Projeto

O projeto está dividido em dois contêineres: um para a aplicação Spring Boot e outro para o banco de dados PostgreSQL.

## Como Executar o Projeto

- Clone o repositório
- Construir e iniciar os contêineres:
```docker-compose
docker-compose up -d
```
- Acessar a API: O serviço estará disponível em http://localhost:8080

## Documentação da API

A documentação da API pode ser acessada em http://localhost:8080/swagger-ui/index.html após a aplicação estar em execução.
