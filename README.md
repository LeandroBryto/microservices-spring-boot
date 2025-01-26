# Microsserviços Spring Boot - Ecommerce Microservices Primavera

## Serviço de Usuário e E-mail

Este projeto é composto por dois microserviços principais: **User Service** e **Email Service**, implementados com **Spring Boot**. O objetivo é gerenciar usuários e enviar e-mails de confirmação de cadastro para os mesmos, usando **RabbitMQ** para comunicação entre os serviços e **SMTP** para envio de e-mails.

---

## Tecnologias Utilizadas

### Serviço de Usuário

- **Spring Boot**: Framework para criar a aplicação.
- **Spring Data JPA**: Para persistência de dados no banco de dados **MySQL**.
- **RabbitMQ**: Para enviar mensagens entre os microserviços.
- **Spring Validation**: Para validação de entradas (DTOs).
- **Swagger**: Para documentação da API.
- **MySQL**: Banco de dados relacional para armazenar as informações do usuário.
- **Slf4j / Logback**: Para logging de eventos importantes.

### Serviço de E-mail

- **Spring Boot**: Framework para a aplicação.
- **Spring Mail**: Para envio de e-mails via **SMTP**.
- **RabbitMQ**: Para receber mensagens de outros microserviços e processá-las.
- **JavaMailSender**: Para envio de e-mails.
- **Slf4j / Logback**: Para logging de eventos importantes.

---

## Como Rodar o Projeto

### Configurações Iniciais

Certifique-se de ter o **MySQL** e o **RabbitMQ** rodando localmente ou configurados adequadamente. Você pode usar serviços em nuvem como **CloudAMQP** para RabbitMQ e um banco **MySQL** local ou na nuvem.

### Configuração do Banco de Dados

Crie um banco de dados chamado **ms_user** para o serviço de usuários e **ms_email** para o serviço de e-mails.

### Configuração do RabbitMQ

A configuração do **RabbitMQ** está presente no arquivo `application.properties` de cada serviço. Adicione as credenciais adequadas para sua instância do RabbitMQ.

### Configuração do E-mail

No `application.properties` de cada serviço, configure as propriedades **SMTP** para envio de e-mails.

---

## Executando os Serviços

- **Serviço de Usuário**: Para rodar o serviço de usuários, execute o comando:

```bash
mvn spring-boot:run
