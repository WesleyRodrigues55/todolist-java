## O que é o projeto?

Um TodoList.

Desenvolvimento de uma aplicação back-end em Java, Maven, Spring Boot, API Rest, Lombok, Integração
com H2 Database Engine, Implementando segurança nos dados do usuário, Tratamento de Exceções e Deploy do
back-end.

Projeto feito no Minicurso de Java da Rocketseat, com 5h de duração.


## Estrutura da API Rest

- **`users/`**: Contém a requisição `create` para criar um novo usuário

Exemplo:
   ```bash
    POST http://localhost:8080/users/
   ```

- **`tasks/`**: Contém 3 endpoints sendo POST, PUT e GET

Exemplo:
   ```bash
   POST http://localhost:8080/tasks/

   GET http://localhost:8080/tasks/

   PUT http://localhost:8080/tasks/{idTask}
   ```

Veja mais sobre o `body` e `header` das requisições na coleção do [postman](https://github.com/WesleyRodrigues55/todolist-java/blob/main/todolist%20-%20minicurso%20java.postman_collection.json). 


## Requisitos para o projeto

- **Java** 17
- **Maven** para gerenciar dependências e empacotamento


## Como Rodar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/WesleyRodrigues55/todolist-java.git
   cd todolist-java
   ```

2. Navegue para o projeto:
   ```bash
    cd todolist-java
   ```

3. Instale as dependências:
    ```bash
    mvn clean install
    ```
   
4. Execute o projeto:
    ```bash
    java -jar target/todolist-1.0.0.jar
    ```

## Base de dados

Foi utilizado o [H2 Databse Engine](https://h2database.com/html/main.html) para armazenamento em memória.

Para acessar a base de dados, após a execução do passo acima, acesse no navegador a URL:
```bash
http://localhost:8080/h2-console
```

E entre com o login e senha: `admin`

Pode mudar as configurações do H2 aqui: [todolist-java/src/main/resources/application.properties](https://github.com/WesleyRodrigues55/todolist-java/blob/main/src/main/resources/application.properties)


## Deploy server

Há um arquivo `Dockerfile` com configurações mínimas, para caso deseje rodar em um outro ambiente.