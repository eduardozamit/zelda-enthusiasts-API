#  ⚔️ ZELDA ENTHUSIASTS API ⚔️

![Zelda Enthusiasts API](https://github.com/amandakummeldeandrtadepero/bolo/blob/main/6mx.gif)

## DESCRIÇÃO ✏️

O **Zelda Enthusiasts API** é um projeto final desenvolvido como parte do nosso curso. Ele adota uma abordagem de micro serviços para criar uma plataforma para entusiastas da franquia Zelda, permitindo que os usuários mantenham uma lista de seus jogos favoritos.

### Microserviços:

1. [API de Usuário (CRUD)](https://github.com/eduardozamit/zelda-enthusiasts-API/tree/main/user-service)
2. [API de Consulta à API Pública Zelda](https://github.com/eduardozamit/zelda-enthusiasts-API/tree/main/zelda-service)
3. [API Gateway para Integração](https://github.com/eduardozamit/zelda-enthusiasts-API/tree/main/gateway-service)

## TECNOLOGIAS UTILIZADAS 🚀

- [Flyway](https://flywaydb.org) para gerenciamento de migrações de banco de dados.
- [WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html) para programação reativa.
- [Spring Boot](https://spring.io/projects/spring-boot) para desenvolvimento de aplicativos Java.
- [Spring Security](https://spring.io/projects/spring-security) para segurança de aplicativos.
- [Lombok](https://projectlombok.org) para reduzir a verbosidade do código.
- [Spring Validation](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-config-validation) para validação de dados.
- [JUnit 5](https://junit.org/junit5/) para testes.
- [Log4j](https://logging.apache.org/log4j/2.x/) para logging.

## CONFIGURAÇÃO E EXECUÇÃO 🚀

### Requisitos:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Gradle](https://gradle.org)

### Instruções:

1. Clone o repositório:
    ```bash
    git clone https://github.com/eduardozamit/zelda-enthusiasts-API.git
    ```

2. Navegue até o diretório do projeto:
    ```bash
    cd zelda-enthusiasts-API
    ```

3. Abra cada microserviço no IntelliJ IDEA.

4. Execute o projeto usando o Gradle.

## ESTRUTURA DO PROJETO 📁

```plaintext
zelda-enthusiasts-API/
|-- user-service/
|-- zelda-service/
|-- gateway-service/
|-- build.gradle
|-- settings.gradle
|-- ...
```

## FLYWAY MIGRATIONS E BANCO DE DADOS 🛠️

O projeto utiliza o Flyway para gerenciar as migrações do banco de dados. Abaixo está a versão inicial (V1) da tabela `users`:

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL
);
```

## EXEMPLOS DE USO 🎮

O projeto foi projetado para ser acessado pelo `gateway-service`, que possui rotas para acessar as outras APIs. Aqui estão alguns exemplos de como interagir com o sistema:

1. **Criar um novo usuário:**
   - **Endpoint:** `POST /users`
   - **Corpo da solicitação:**
     ```json
     {
       "name": "Nome do Usuário",
       "age": 25
     }
     ```

2. **Obter jogos da franquia Zelda por id:**
   - **Endpoint:** `GET /api/games/{gameId}`
   - **Parâmetros da consulta: (opcionais)**
     ```json
     {
     "success": true,
     "count": 0,
     "data": {
        "name": "The Legend of Zelda",
        "description": "The Legend of Zelda is the first installment of the Zelda series. It centers its plot around a boy named Link, who becomes the central protagonist throughout the series. It came out as early as 1986 for the Famicom in Japan, and was later released in the western world, including Europe and the US in 1987. It has since then been re-released several times, for the Nintendo GameCube as well as the Game Boy Advance. The Japanese version of the game on the Famicom is known as The Hyrule Fantasy: The Legend of Zelda. ",
        "developer": "Nintendo R&D 4",
        "publisher": "Nintendo",
        "released_date": " February 21, 1986",
        "id": "5f6ce9d805615a85623ec2b7"
     }
     }
     ```

## INTEGRANTES 🧝‍♂️🧝‍♀️

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/amandakummeldeandrtadepero">
       <img src="https://github.com/amandakummeldeandrtadepero.png "smartCard-inline) " width="100px;" alt="Foto da Amanda kummel"/><br>
        <sub>
          <b>Amanda kummel</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/eduardozamit">
        <img src="https://github.com/eduardozamit.png "smartCard-inline) " width="100px;" alt="Foto do Eduardo Zamit"/><br>
        <sub>
          <b>Eduardo Zamit</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Mateufraga">
        <img src="https://github.com/Mateufraga.png " smartCard-inline) " width="100px;" alt="Foto do Matheus Fraga"/><br>
        <sub>
          <b>Matheus Fraga</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/GabrielMartinsPastoriza">
        <img src="https://github.com/GabrielMartinsPastoriza.png" smartCard-inline) " width="100px;" alt="Foto do Gabriel Martins"/><br>
        <sub>
          <b>Gabriel Martins</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/anitaeverywhere">
        <img src="https://github.com/anitaeverywhere.png "smartCard-inline) " width="100px;" alt="Foto da Anita Sampaio"/><br>
        <sub>
          <b>Anita Sampaio</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## AGRADECIMENTO 💚

Agradeço sinceramente aos professores Diego e Jean pela dedicação e paciência ao compartilhar conhecimento. Vocês são verdadeiros inspiradores, moldando o futuro com sabedoria e generosidade. Muito obrigado!

![image](https://github.com/amandakummeldeandrtadepero/bolo/blob/main/17mb.gif)
