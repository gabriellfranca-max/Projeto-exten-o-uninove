# Sistema de Gerenciamento de Tarefas — Professor e Aluno

## 📌 Sobre o Projeto

Este sistema é uma aplicação web desenvolvida em **Java + Spring Boot** que permite a interação entre professores e alunos. Professores podem criar, editar e excluir tarefas; alunos podem visualizar as atividades atribuídas.

O projeto utiliza autenticação com **Spring Security**, acesso restrito por perfis (Professor/Aluno), persistência via **MySQL**, além de **Thymeleaf** no frontend.

---

## 🚀 Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3.x**
* **Spring MVC**
* **Spring Security**
* **Spring Data JPA**
* **MySQL 8**
* **Maven**
* **Thymeleaf**
* HTML5 + CSS3

---

## 📂 Estrutura do Projeto

```
sistema-tarefas/
├── src/main/java/com/sistema/sistema_tarefas/
│   ├── controller/   # Controladores MVC
│   ├── entity/       # Entidades JPA
│   ├── repository/   # Repositórios JPA
│   ├── service/      # Regras de negócio
│   └── security/     # Autenticação e autorização
├── src/main/resources/
│   ├── templates/    # Páginas Thymeleaf
│   └── static/css/   # Estilos CSS
└── database/         # Script SQL
```

---

## 🛠️ Como Executar o Projeto (passo a passo)

### 1️⃣ Pré-requisitos

Certifique‑se de ter instalado:

* **Java 17** → [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
* **Maven** → [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)
* **MySQL 8** → [https://dev.mysql.com/downloads/](https://dev.mysql.com/downloads/)
* (Opcional) **MySQL Workbench**
* **VS Code ou IntelliJ**

---

## 2️⃣ Clonar o repositório

```
git clone https://github.com/gabriellfranca-max/Projeto-exten-o-uninove.git
```

Entre no diretório:

```
cd Projeto-exten-o-uninove
```

---

## 3️⃣ Configurar o Banco de Dados

1. Crie um banco chamado:

```
sistema_tarefas
```

2. No MySQL Workbench, execute o arquivo SQL que está na pasta `/database`.

3. Depois, abra o arquivo `application.properties`:

```
src/main/resources/application.properties
```

Configure conforme seu MySQL:

```
spring.datasource.url=jdbc:mysql://localhost:3306/sistema_tarefas
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
```

---

## 4️⃣ Executar o Projeto

No terminal dentro do projeto:

```
mvn spring-boot:run
```

Ou abra na IDE e execute a classe principal:

```
SistemaTarefasApplication.java
```

---

## 5️⃣ Acessar o Sistema

Abra o navegador:

```
http://localhost:8080/login
```

---

## 👥 Perfis de Usuário

### 🔑 Credenciais de Teste

| Tipo      | E-mail                                                | Senha |
| --------- | ----------------------------------------------------- | ----- |
| Professor | [professor@sistema.com](mailto:professor@sistema.com) | 1234  |
| Aluno     | [aluno@sistema.com](mailto:aluno@sistema.com)         | 1234  |

### Professor

* Pode criar, editar e excluir tarefas
* Pode visualizar todas as tarefas criadas

### Aluno

* Pode visualizar apenas suas tarefas

---

## 🔐 Segurança

O sistema utiliza:

* **Autenticação com Spring Security**
* **Criptografia de senha com BCrypt**
* **Controle de acesso baseado em roles**

---

## 🎥 Vídeo Explicativo (opcional para +4 pontos)

Inclua aqui o link do vídeo quando estiver pronto.

---

## 📄 Autores

* Erick Adriano de Oliveira Silva – RA: 3025107900
* Gabriell Silva França Lau – RA: 3025200966

UNINOVE – Universidade Nove de Julho
