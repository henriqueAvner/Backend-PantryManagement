# Pantry Management API

API RESTful para gerenciamento de despensa desenvolvida com Spring Boot 4.0.1 e Java 17.

## 💻 Tecnologias

- **Spring Boot 4.0.1** - Framework principal
- **Java 17** - Linguagem
- **Spring Data JPA** - ORM com Hibernate
- **MySQL** - Banco de dados
- **Lombok** - Geração de código
- **Spring Validation** - Validação de dados
- **Spring Boot Actuator** - Monitoramento
- **Maven** - Build tool

## 🏗️ Arquitetura em Camadas

```
Controllers (DTOs) → Services → Repositories → Entities → MySQL
```

### **1. Controllers** (`/controllers`)
- Recebem requisições HTTP
- Validam entrada e convertem para DTOs
- Retornam respostas padronizadas

### **2. Services** (`/services`)
- Implementam lógica de negócio
- Orquestram operações de repositórios
- Lançam exceções personalizadas

### **3. Repositories** (`/models/repository`)
- Interface JpaRepository para CRUD
- Operações diretas com banco de dados
- Suporte para queries customizadas

### **4. Entities** (`/models/entity`)
- Mapeamento ORM das tabelas
- Relacionamentos (1:1, 1:N, N:M)
- Anotações JPA/Jakarta Persistence

## 📦 Estrutura

```
src/main/java/
├── com/api/pantry_management/
├── controllers/ (UserController, GlobalControllerAdvice, DTOs)
├── services/ (UserService, exceções)
├── models/
│   ├── entity/ (User, Product, Category, ShoppingList, MovimentHistory)
│   └── repository/ (Repositories JPA)
```

## 🚀 Quick Start

**Pré-requisitos**: Java 17+, Maven 3.6+, MySQL 5.7+

```bash
# Instalar dependências
mvn clean install

# Executar
mvn spring-boot:run
```

## ⚙️ Configuração

Configure `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pantry_management
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## API Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/users` | Listar usuários |
| GET | `/users/{id}` | Obter usuário |
| POST | `/users` | Criar usuário |
| PUT | `/users/{id}` | Atualizar usuário |
| DELETE | `/users/{id}` | Deletar usuário |
| GET | `/actuator/health` | Status da aplicação |

## 🧪 Testes

```bash
mvn test
```

---

**Desenvolvido com Spring Boot**
