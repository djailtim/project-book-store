## Projeto Final - Módulo Testes Automatizados

Implementar uma API básica(CRUD) com as camadas de Repository, Service e Controller de um cadastro de livros, utilizando um banco de dados em memória.

### Requisitos Funcionais

É necessário cadastrar um novo livro no sistema. Todo livro deve ter os seguintes atributos abaixo:

- Um título
- Um resumo do que vai ser encontrado no livro
- Um sumário de tamanho livre.
- Preço do livro
- Número de páginas
- Isbn(identificador do livro)
- Data que ele deve entrar no ar(de publicação)


- Deve ser possível realizar a atualização dos dados de um livro cadastrado no sistema.
- Deve ser possível buscar um livro pelo id.
- Deve possível listar todos os livros.
- Deve ser possível excluir um livro do cadastro.

#### Restrições

- Título é obrigatório
- Resumo é obrigatório e tem no máximo 500 caracteres
- O sumário é de tamanho livre.
- Preço é obrigatório e o mínimo é de 20
- Número de páginas é obrigatória e o mínimo é de 100
- Isbn é obrigatório, formato livre
- Data que vai entrar no ar precisa ser no futuro
- Requisitos não funcionais obrigatórios

A aplicação precisa ter cobertura mínima de 80% do código da API.

Realizar pelo menos 2 testes de integração, com um banco em memória a sua escolha.

#### Requisitos opcionais

Criar uma interface simples para todos os endpoints da API e realizar testes de interface com Selenium.