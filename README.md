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
- Spring Boot
- PostgreSQL

## Status do projeto 🚧
Em desenvolvimento. Etapas atuais:
- [x] Planejamento e modelagem
- [ ] Configuração do projeto Spring Boot
- [ ] Implementação da API REST
- [ ] Frontend
- [ ] Testes automatizados
- [ ] Deploy
