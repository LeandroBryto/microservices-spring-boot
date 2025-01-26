Microsserviços Spring Boot - Ecommerce Microservices Primavera
Serviço de Usuário e E-mail
Este projeto é composto por dois microserviços principais: User Service e Email Service, implementados com Spring Boot. O objetivo é gerenciar usuários e enviar e-mails de confirmação de cadastro para os mesmos, usando RabbitMQ para comunicação entre os serviços e SMTP para envio de e-mails.

Tecnologias Utilizadas
Serviço de Usuário
Spring Boot: Framework para criar a aplicação.
Spring Data JPA: Para persistência de dados no banco de dados MySQL.
RabbitMQ: Para enviar mensagens entre os microserviços.
Spring Validation: Para validação de entradas (DTOs).
Swagger: Para documentação da API.
MySQL: Banco de dados relacional para armazenar as informações do usuário.
Slf4j / Logback: Para logging de eventos importantes.
Serviço de E-mail
Spring Boot: Framework para a aplicação.
Spring Mail: Para envio de e-mails via SMTP.
RabbitMQ: Para receber mensagens de outros microserviços e processá-las.
JavaMailSender: Para envio de e-mails.
Slf4j / Logback: Para logging de eventos importantes.
Como Rodar o Projeto
Configurações Iniciais
Certifique-se de ter o MySQL e o RabbitMQ rodando localmente ou configurados adequadamente. Você pode usar serviços em nuvem como CloudAMQP para RabbitMQ e um banco MySQL local ou na nuvem.

Configuração do Banco de Dados
Crie um banco de dados chamado ms_user para o serviço de usuários e ms_email para o serviço de e-mails.

Configuração do RabbitMQ
A configuração do RabbitMQ está presente no arquivo application.properties de cada serviço. Adicione as credenciais adequadas para sua instância do RabbitMQ.

Configuração do E-mail
No application.properties de cada serviço, configure as propriedades SMTP para envio de e-mails.

Executando os Serviços
Serviço de Usuário: Para rodar o serviço de usuários, execute o comando:
bash
Copiar
Editar
mvn spring-boot:run
no diretório do User Service.

Serviço de E-mail: Para rodar o serviço de e-mail, execute o comando:
bash
Copiar
Editar
mvn spring-boot:run
no diretório do Email Service.

Fluxo de Funcionamento
O User Service recebe uma requisição para criar um novo usuário via POST /users.
O User Service persiste o usuário no banco de dados ms_user e envia uma mensagem via RabbitMQ para o Email Service.
O Email Service escuta a fila do RabbitMQ, processa a mensagem e envia um e-mail de confirmação para o usuário.
O e-mail é enviado usando o servidor SMTP configurado e o status do e-mail é registrado no banco ms_email.
Logs
Os logs são gerados usando Slf4j e podem ser visualizados para depuração. Os logs incluem informações sobre o processo de criação de usuários, envio de e-mails e possíveis erros durante as operações.

Dependências
Spring Boot: Para a construção da aplicação e gerenciamento de dependências.
Spring Data JPA: Para o gerenciamento da persistência de dados.
Spring Mail: Para envio de e-mails via SMTP.
Spring AMQP: Para comunicação com o RabbitMQ.
H2 Database: Usado para testes locais.
