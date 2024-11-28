## O que é o projeto?

Um TodoList.

Desenvolvimento de uma aplicação back-end em Java, Maven, Spring Boot, API Rest, Lombok, Integração
com H2 Database Engine, Implementando segurança nos dados do usuário, Tratamento de Exceções e Deploy do
back-end.

Projeto feito no Minicurso de Java da Rocketseat, com 5h de duração.

---
## Estrutura da API Rest

**`users/`**: Contém 1 endpoint sendo POST, responsável por criar o usuário e realizar a autenticação

Exemplo:
   ```bash
    create user - POST {url}/users/
   ```
---
**`tasks/`**: Contém 4 endpoints sendo POST, PUT e 2 GET

Exemplo:
   ```bash
   create task - POST {url}/tasks/

   list tasks - GET {url}/tasks/
   
   list task by id - GET {url}/tasks/get-task/{taskId}

   update task - PUT {url}/tasks/{taskId}
   ```
---
**`items-task/`**: Contém 2 endpoints sendo POST e PUT

Exemplo:
   ```bash
    create item task - POST {url}/items-task/
    update item task - PUT {url}/items-task/{id}
   ```

Veja mais sobre o `body` e `header` das requisições na coleção do [insominia](https://github.com/WesleyRodrigues55/todolist-java/blob/main/Insomnia_2024-11-27.json). 

---
## Requisitos para o projeto

- **Java** 17
- **Maven** para gerenciar dependências e empacotamento

---
## Como Rodar Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/WesleyRodrigues55/todolist-java.git
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

---
## Base de dados

Foi utilizado o [H2 Database Engine](https://h2database.com/html/main.html) para armazenamento em memória.

Para acessar a base de dados, após a execução do passo acima, acesse no navegador a URL:
```bash
http://localhost:8080/h2-console
```

E entre com o login e senha: `admin`

Pode mudar as configurações do H2 aqui: [todolist-java/src/main/resources/application.properties](https://github.com/WesleyRodrigues55/todolist-java/blob/main/src/main/resources/application.properties)


---
## Deploy server

Há um arquivo `Dockerfile` com configurações mínimas, para caso deseje rodar em um outro ambiente.