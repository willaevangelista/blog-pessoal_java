<div align='center', id='topo'/>

  # 📝 Projeto Blog Pessoal - Backend com Spring
</div>

O projeto **Blog Pessoal** é uma aplicação backend desenvolvida com o Spring Framework. O objetivo principal deste sistema é criar uma API CRUD para gerenciar postagens e usuários em um blog, utilizando as boas práticas de desenvolvimento, arquitetura em camadas (Model, Repository, Service, Controller) e segurança com autenticação JWT.  

******

<div align='center'/>

  ![Java](https://a11ybadges.com/badge?logo=java)
  ![Spring](https://a11ybadges.com/badge?logo=spring)
  ![MySQL](https://a11ybadges.com/badge?logo=mysql)
  ![Insomnia](https://a11ybadges.com/badge?logo=insomnia)

</div>

******
### 📌 Tabela de Conteúdo  
 1. [Conhecimentos Mobilizados](#conhecimentosMobilizados)  
 2. [Estrutura do Projeto](#estruturaDoProjeto)  
 3. [Código Desenvolvido](#codigoDesenvolvido)  
 4. [Tecnologias Utilizadas](#tecnologiasUtilizadas)  
******

<div id='conhecimentosMobilizados'/> 

## 💡 Conhecimentos Mobilizados  
- **Spring Framework:** Utilização do Spring Boot para construção de APIs RESTful.  
- **JPA e Hibernate:** Mapeamento objeto-relacional para interação com o banco de dados MySQL.  
- **Arquitetura MVC:** Implementação da arquitetura em camadas (Model, Repository, Service, Controller).  
- **Banco de Dados:** Configuração do banco MySQL e persistência com Spring Data JPA.  
- **RESTful API:** Implementação de endpoints CRUD para postagens e usuários.  
- **Segurança:** Autenticação de usuários com Spring Security e JWT (JSON Web Token).  

<div id='estruturaDoProjeto'/> 

## 🏗️ Estrutura do Projeto  

  
```
blogpessoal/
├── controller/
│   ├── PostagemController.java
│   ├── UsuarioController.java
├── model/
│   ├── Postagem.java
│   ├── Usuario.java
│   ├── UsuarioLogin.java
├── repository/
│   ├── PostagemRepository.java
│   ├── UsuarioRepository.java
├── security/
│   ├── BasicSecurityConfig.java
│   ├── JwtAuthFilter.java
│   ├── JwtService.java
│   ├── UserDetailsImpl.java
│   ├── UserDetailsServiceImpl.java
├── service/
│   ├── UsuarioService.java
├── resources/
│   ├── application.properties
└── BlogPessoalApplication.java

```

<div id='codigoDesenvolvido'/> 

## 📂 Código Desenvolvido  

Para melhor visualização, aqui estão os links para os códigos principais:  

- **[PostagemController](src/blogpessoal/controller/PostagemController.java):** Controlador responsável pelas postagens. Implementa métodos CRUD.  
- **[UsuarioController](src/blogpessoal/controller/UsuarioController.java):** Controlador responsável pelos usuários. Implementa `getAll()`, `getById()`, `post()`, `put()`, `logar()`.  
- **[Postagem](src/blogpessoal/model/Postagem.java):** Entidade que representa as postagens no banco de dados.  
- **[Usuario](src/blogpessoal/model/Usuario.java):** Entidade que representa os usuários no banco de dados.  
- **[UsuarioLogin](src/blogpessoal/model/UsuarioLogin.java):** Modelo auxiliar para login, sem persistência no banco.  
- **[UsuarioRepository](src/blogpessoal/repository/UsuarioRepository.java):** Interface que permite buscar usuários pelo e-mail.  
- **[UsuarioService](src/blogpessoal/service/UsuarioService.java):** Serviço responsável por `cadastrarUsuario()`, `atualizarUsuario()` e `autenticarUsuario()`.  
- **[BasicSecurityConfig](src/blogpessoal/security/BasicSecurityConfig.java):** Configuração de autenticação e autorização.  
- **[JwtService](src/blogpessoal/security/JwtService.java):** Serviço para geração e validação de tokens JWT.  
- **[JwtAuthFilter](src/blogpessoal/security/JwtAuthFilter.java):** Filtro responsável por validar tokens em requisições autenticadas.  

<div id='tecnologiasUtilizadas'/>  

## 🛠️ Tecnologias Utilizadas  

- **Linguagem:** Java  
- **Framework:** Spring Boot  
- **Banco de Dados:** MySQL  
- **JPA/Hibernate:** Para persistência de dados  
- **Spring Security:** Para autenticação e autorização  
- **JWT:** Para autenticação baseada em tokens  
- **IDE utilizada:** Spring Tools Suite (STS)  
- **Ferramenta de Testes:** Insomnia  

<div align='right'>

  [Voltar ao Topo ⬆️](#topo)  

</div>
