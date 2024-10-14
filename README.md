
# Digimon API

Esta é uma API desenvolvida em Spring Boot  para gerenciar Digimons. A aplicação permite adicionar, listar e buscar Digimons por nome e nível.
Usei o PostgreSQL e usei o Swagger para fácil acesso e teste das rotas disponíveis.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
com.projeto.Digimon
│
├── controller
│   └── DigimonContainer - Controlador para gerenciamento das rotas da API.
│
├── dto
│   └── DigimonDto - Objeto de transferência de dados para os Digimons.
│
├── entity
│   └── Digimon - Entidade que representa o modelo de dados do Digimon.
│
├── exception
│   ├── GlobalExceptionHandler - Manipulador global de exceções.
│   └── ResourceNotFoundException - Exceção personalizada para recursos não encontrados.
│
├── mapper
│   └── DigimonMapper - Classe para mapear entidades para DTOs e vice-versa.
│
├── repository
│   └── DigimonRepository - Interface de acesso ao banco de dados.
│
├── service
│   ├── DigimonService - Interface que define os métodos do serviço.
│   └── impl
│       └── DigimonServiceImpl - Implementação dos métodos de serviço.
│
└── resources
    ├── application.properties - Configurações da aplicação e do banco de dados.
    └── static
        └── Swagger UI
```

## Documentação

A API está documentada utilizando o Swagger. Você pode acessar a documentação completa da API através do seguinte endereço após iniciar a aplicação:

```
http://localhost:8080/swagger-ui.html
```

A documentação inclui todas as rotas disponíveis, métodos e parâmetros esperados, permitindo fácil interação e teste.  
Mas Basicamente temos Uma opção de Post para apenas um Digimon e Outra (/bulk) que recebe o array dos digimons. E outras rotas que retornam todos, pesquisa por nome e por level.

## Configuração do Banco de Dados
Como eu não usei variáveis de ambiente para ser mais simples, a conexão com o Postgre, foi usado o username e senha padrões, mas podem ser editados no application.properties
## Como Popular o Banco de Dados

Para popular o banco, eu criei uma rota que aceita um array que contem todos os digimons (arquivo databse.json) 
Assim é possível salvar todos os digimons de uma vez.
```
POST /api/digimon/bulk
```

## Executando a Aplicação

Para iniciar a aplicação, execute o seguinte comando na raiz do projeto:
```bash
mvn spring-boot:run
```
ou, se estiver utilizando um jar:
```bash
java -jar target/digimon-api.jar
```
