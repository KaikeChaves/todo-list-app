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
- [x] Deploy
- [ ] Frontend

## API em produção
A API está disponível publicamente em: `https://todo-list-api-3gsr.onrender.com/`

> Hospedada no plano gratuito do Render — a primeira requisição após um período de inatividade pode demorar cerca de 1 minuto para responder (o serviço "acorda" do modo de hibernação).

## Como rodar o projeto localmente

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
   cp backend/src/main/resources/application-dev.properties.example backend/src/main/resources/application-dev.properties
   ```
Edite o arquivo copiado com suas credenciais do PostgreSQL local.
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

## Exemplos de uso

Substitua `{URL}` pela URL em produção ou por `http://localhost:8080` se estiver rodando localmente.

### Criar uma tarefa
```bash
curl -X POST {URL}/tarefas \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Estudar Spring Boot",
    "descricao": "Terminar o projeto",
    "dataLimite": "2026-08-01"
  }'
```

### Listar todas as tarefas
```bash
curl {URL}/tarefas
```

### Buscar uma tarefa específica
```bash
curl {URL}/tarefas/1
```

### Atualizar uma tarefa
```bash
curl -X PUT {URL}/tarefas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Estudar Spring Boot - Atualizado",
    "descricao": "Revisar conceitos",
    "dataLimite": "2026-08-05"
  }'
```

### Marcar tarefa como concluída
```bash
curl -X PATCH {URL}/tarefas/1/concluir
```

### Excluir uma tarefa
```bash
curl -X DELETE {URL}/tarefas/1
```