<div align="center">
  
  ![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange)
</div>

<div align="center">

  # POC - Micronaut, Kotlin e GRPC.
  Trata-se de uma aplicação de prova de conceito para aplicar CRUD utilizando arquitetura: Micronaut, Kotlin e GRPC

  ![](https://img.shields.io/badge/Autor-Wesley%20Oliveira%20Santos-brightgreen)
  ![](https://img.shields.io/badge/Language-Kotlin-brightgreen)
  ![](https://img.shields.io/badge/Framework-Micronaut-brightgreen)
  ![](https://img.shields.io/badge/HTTP2-gRPC-brightgreen)
  
</div> 

## Fundamentos teóricos

> Micronaut: Microunaut é um framework baseado na JVM para criação de micros-serviços inspirado pelo Spring e Grails e permite a criação de aplicações utilizando Java, Kotlin ou Groovy.

> gRPC: gRPC é uma tecnologia open source e de alta performance empregada em chamadas remotas (daí o RPC em seu nome, sigla de Remote Procedure Call). Desenvolvido originalmente pela Google, emprega o formato binário Protobuf para a serialização de dados e HTTP/2 como protocolo de comunicação..

> Protocol Buffer: Protocol buffer ou protobuf é um método criado pelo Google de serialização de dados estruturados, agnóstico de linguagem. A transferência de dados chega a ser até 6x mais rápida que um JSON. O gRPC utiliza o arquivo com extensão .proto para criar o código base, garantindo o Contract-first.

## Tecnologias
- Kotlin 1.4.30
- Micronaut 2.3.3
    - micronaut-validation
    - micronaut-kotlin-runtime
    - micronaut-grpc-runtime
    - micronaut-jdbc-hikari
    - micronaut-data-jdbc
    - micronaut-data-processor
- testcontainers
- Flywaydb
- Mysql
- GIT

## Execução

A execução das aplicações são feitas através do de um comando Gradle que envoca a inicialização do Micronaut.

- Scripts
    ### Executar docker-compose
    - 1° comando: ``` cd src/main/docker/``` 
    - 2° comando: ```docker-compose -f docker-compose.yml up``` 
    ### Executar a aplicação
    - 1° comando: ``` ./gradlew build``` 
    - 2° comando: ```./gradlew run``` 

## Utilização
 - Aternativas open source do client para testar serviços gRPC
  -  [BloomRPC](https://appimage.github.io/BloomRPC/)
  -  [Insomnia](https://insomnia.rest/)
    
