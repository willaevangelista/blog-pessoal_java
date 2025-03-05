# 📝 Projeto Blog Pessoal - Backend com Spring

O projeto **Blog Pessoal** é uma aplicação backend desenvolvida com o Spring Framework. O objetivo principal deste sistema é criar uma API CRUD para gerenciar postagens em um blog, utilizando as boas práticas de desenvolvimento e arquitetura em camadas (Model, Repository, Controller).
******

<div align='center'/>

  ![Java](https://a11ybadges.com/badge?logo=java)
  ![Spring](https://a11ybadges.com/badge?logo=spring)
  ![MySQL](https://a11ybadges.com/badge?logo=mysql)
  ![Insomnia](https://a11ybadges.com/badge?logo=insomnia)
</div>


******
### Tabela de Conteúdo 
 1. [Conhecimentos Mobilizados](#conhecimentosMobilizados)
 2. [Estrutura do Projeto](#estruturaDoProjeto)
 3. [Código Desenvolvido](#codigoDesenvolvido)
 4. [Tecnologias Utilizadas](#tecnologiasUtilizadas)
******

<div id='conhecimentosMobilizados'/> 
  
## 💡 Conhecimentos Mobilizados
- **Spring Framework:** Utilização do Spring Boot para construção de APIs RESTful, com ênfase nas boas práticas de desenvolvimento.
- **JPA e Hibernate:** Mapeamento objeto-relacional para interação com o banco de dados MySQL.
- **Padrões de projeto:** Implementação da arquitetura em camadas (Model, Repository, Controller) e boas práticas para organização do código.
- **Banco de Dados:** Criação e configuração de banco de dados MySQL, utilizando o Spring Data JPA para persistência de dados.
- **RESTful API:** Criação de endpoints para manipulação de postagens no blog, com operações CRUD.

<div id='estruturaDoProjeto'/> 
  
## 🏗️ Estrutura do Projeto
```
blogpessoal/
├── controller/
│   └── PostagemController.java
├── model/
│   └── Postagem.java
├── repository/
│   └── PostagemRepository.java
├── resources/
│   └── application.properties
└── BlogPessoalApplication.java
```
<div id='codigoDesenvolvido'/> 
  
## 📂 Código Desenvolvido

Para melhor visualização, aqui estão os links para os códigos principais:  

- **[PostagemController](src/blogpessoal/controller/PostagemController.java):** Controlador responsável pela manipulação das postagens. Implementa o método `getAll()` para listar todas as postagens.
- **[Postagem](src/blogpessoal/model/Postagem.java):** Modelo que representa a entidade de uma postagem no banco de dados. Inclui atributos como `id`, `titulo`, `conteudo` e `dataCriacao`.
- **[PostagemRepository](src/blogpessoal/repository/PostagemRepository.java):** Interface que estende `JpaRepository` e permite a comunicação com o banco de dados MySQL.
- **[application.properties](src/blogpessoal/resources/application.properties):** Arquivo de configuração que define a conexão com o banco de dados MySQL, incluindo o nome do banco (`db_blogpessoal`) e outras propriedades do Spring.
- **[BlogPessoalApplication](src/blogpessoal/BlogPessoalApplication.java):** Classe principal que inicializa a aplicação Spring Boot.

<div id='tecnologiasUtilizadas'/> 

## 🛠️ Tecnologias Utilizadas  

- **Linguagem:** Java  
- **Framework:** Spring Boot  
- **Banco de Dados:** MySQL  
- **JPA/Hibernate:** Para persistência de dados  
- **IDE utilizada:** Spring Tools Suite (STS)  
- **Ferramenta de Testes:** Insomnia 

