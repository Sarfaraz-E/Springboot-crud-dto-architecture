 🎓 Spring Boot CRUD Application with DTO Architecture

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2-green)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14-blue)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow)](LICENSE)

A **RESTful Spring Boot application** implementing **3-layer architecture** (Controller → Service → Repository) with **DTO pattern**, designed to manage **student data** with full CRUD operations.

---

## 🚀 Features

- **3-Layer Architecture** for clean and maintainable code.
- **DTO Pattern** to separate entity objects from API responses/requests.
- Full **CRUD operations**:
  - `GET /students` – List all students
  - `GET /students/{id}` – Get student by ID
  - `POST /students` – Create a new student
  - `PUT /students/{id}` – Update entire student
  - `PATCH /students/{id}` – Update partial student
  - `DELETE /students/{id}` – Delete a student
- **ResponseEntity** used to return proper HTTP status codes:
  - `200 OK` – Success
  - `201 Created` – Resource created
  - `204 No Content` – Resource deleted
- Validations using **Jakarta Validation (@Valid)**
- **Lombok** for boilerplate reduction

---

## 🏗 Architecture Overview

```

Controller Layer   -> Handles API requests and HTTP responses
Service Layer      -> Business logic, validation, and DTO mapping
Repository Layer   -> Database interactions via Spring Data JPA
DTO Layer          -> Request/Response mapping (AddStudentRequestDto, StudentDto)
Entity Layer       -> JPA entities mapped to database tables

```

---

## 📁 Project Structure

```

src/main/java/com/example/demo
├── controller
│   └── StudentController.java
├── service
│   └── StudentService.java
├── repository
│   └── StudentRepository.java
├── dto
│   ├── AddStudentRequestDto.java
│   └── StudentDto.java
├── model
│   └── Student.java
└── DemoApplication.java

````

---

## ⚡ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Web (REST API)**
- **Spring Data JPA / Hibernate**
- **PostgreSQL / MySQL**
- **Lombok**
- **Jakarta Validation**
- **Maven**

---

## 🛠 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Sarfaraz-E/Springboot-crud-dto-architecture.git
cd Springboot-crud-dto-architecture
````

### 2. Configure the Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/student_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Or run directly from your IDE (`DemoApplication.java`).

---

## 🌐 API Endpoints

| Method | Endpoint         | Description                | Status Code    |
| ------ | ---------------- | -------------------------- | -------------- |
| GET    | `/students`      | Retrieve all students      | 200 OK         |
| GET    | `/students/{id}` | Retrieve a student by ID   | 200 OK         |
| POST   | `/students`      | Create a new student       | 201 Created    |
| PUT    | `/students/{id}` | Update an existing student | 200 OK         |
| PATCH  | `/students/{id}` | Partially update a student | 200 OK         |
| DELETE | `/students/{id}` | Delete a student           | 204 No Content |

---

## 🔍 Example Requests

**Create Student – POST /students**

```json
{
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "age": 22
}
```

**Response**

```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane.doe@example.com",
  "age": 22
}
```

**Update Partial Student – PATCH /students/1**

```json
{
  "email": "jane.new@example.com"
}
```

**Response**

```json
{
  "id": 1,
  "name": "Jane Doe",
  "email": "jane.new@example.com",
  "age": 22
}
```

---

## 🎯 Why DTOs?

* Protects internal **entity structure** from external exposure.
* Simplifies **validation and transformation**.
* Makes API **more maintainable and secure**.
* Decouples **database model** from **API contract**.

---

## 📊 Testing APIs

You can test the endpoints using:

* **Postman**: [https://www.postman.com/](https://www.postman.com/)
* **Swagger**: Enable Springdoc OpenAPI for interactive documentation:

```java
implementation 'org.springdoc:springdoc-openapi-ui:2.2.0'
```

Access Swagger UI: `http://localhost:8080/swagger-ui.html`

---

## 🖼 Screenshots

<!-- Add screenshots of your application responses or Postman here -->

![Sample Response](./screenshots/sample_response.png)

---

## 📈 Next Steps / Improvements

* Add **unit and integration tests**
* Add **Spring Security** (JWT authentication)
* Add **Swagger documentation** for live API testing
* Deploy on **Heroku / AWS** for live demonstration


---

## 👨‍💻 Author

**Sarfaraz Essa**
[GitHub](https://github.com/Sarfaraz-E)
[LinkedIn](https://www.linkedin.com/in/sarfaraz-essa/) (optional)

```

---

This README is **modern, professional, and visually structured** for portfolios. It includes:

- Badges for Java, Spring Boot, PostgreSQL, and License
- Clear architecture and project structure
- API documentation with sample requests/responses
- Placeholders for **screenshots**
- Next steps for improvements & professional feel  

---

If you want, I can **also generate a fully formatted Markdown with live Swagger links, interactive Postman collection, and ready-to-copy screenshots**, so it’s **portfolio-ready and impresses recruiters**.  

Do you want me to do that?
```
