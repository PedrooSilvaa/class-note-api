# class-note-api

Backend desenvolvido para um sistema de anotações, com **autenticação JWT**. O sistema permite a criação e autenticação de usuários, busca de usuários por nome, troca de senhas e gerenciamento de atividades. Usuários autenticados podem adicionar atividades, listar suas próprias atividades e excluir atividades por ID.

## 🚀 Funcionalidades

- **Autenticação JWT**: Permite que usuários se autentiquem e utilizem tokens JWT para acessar funcionalidades protegidas.
- **Criação de Usuários**: Possibilidade de registrar novos usuários no sistema.
- **Busca de Usuários por Nome**: Funcionalidade para procurar usuários pelo nome.
- **Troca de Senha**: Usuários autenticados podem alterar suas senhas.
- **Gerenciamento de Atividades**: Usuários podem adicionar, listar e excluir atividades pessoais.

## 🚀 Tecnologias Utilizadas

- **C#**: Linguagem de programação utilizada para o desenvolvimento do backend.
- **.NET 6+**: Framework para construção da API.
- **JWT (JSON Web Tokens)**: Autenticação segura usando tokens JWT para proteger as rotas da API.
- **Entity Framework Core**: ORM para interação com o banco de dados.
- **MySQL** (ou outro banco de dados relacional): Banco de dados utilizado para armazenar informações dos usuários e suas atividades.
- **Swagger**: Utilizado para a documentação e testes da API.

## 🛠️ Como Executar o Projeto

Para executar o projeto localmente, siga os passos abaixo:

1. Clone o repositório:

```bash
git clone https://github.com/SeuUsuario/class-note-api.git
