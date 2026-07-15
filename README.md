# TODO List App

## Descrição
Um app contendo tanto o backend da aplicação, com a API para gerenciamento das tarefas (CRUD), quanto o front. Construído para fins de aprendizado.

## Funcionalidades
```bash
POST   /tarefas                → cria uma tarefa
GET    /tarefas                → lista todas
GET    /tarefas/{id}           → busca uma específica
PUT    /tarefas/{id}           → atualiza título/descrição/data
PATCH  /tarefas/{id}/concluir  → marca como concluída
DELETE /tarefas/{id}           → remove
```

## Tecnologias
- Java
- Maven
- Spring Boot
- PostgreSQL

## Status do projeto 🚧
Em desenvolvimento. Etapas atuais:
- [x] Planejamento e modelagem
- [x] Configuração do projeto Spring Boot
- [x] Implementação da API REST
- [x] Tratamento de erros e validação
- [x] Testes automatizados
- [ ] Deploy
- [ ] Frontend

## Como rodar o projeto

### Pré-requisitos
- Java 21
- Maven
- PostgreSQL

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/KaikeChaves/todo-list-app.git
   ```
2. Crie o banco de dados:
   ```sql
   CREATE DATABASE todo_list_db;
   ```
3. Copie o arquivo de exemplo e configure suas credenciais:
   ```bash
   cp backend/src/main/resources/application.properties.example backend/src/main/resources/application.properties
   ```
   Edite o arquivo copiado com suas credenciais do PostgreSQL.
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_list_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
4. Rode a aplicação:
   ```bash
   cd backend
   ./mvnw spring-boot:run
   ```
5. A API estará disponível em `http://localhost:8080`
