# TaskFlow – Secure Task Management API (Spring Boot + JWT)
Looking for Erasmus+ Internship – Full-Stack Development

TaskFlow is a production-grade backend service designed with modern Java technologies.  
Built with a clean architecture and secure JWT authentication, this project demonstrates real backend development skills suitable for professional environments and internship applications 

Purpose & Professional Relevance

This backend was created as part of an Erasmus internship application to demonstrate:
Strong backend development fundamentals
Secure authentication flows
Hands-on experience with Java & Spring Boot
Database design and ORM usage
Clean code and scalable architecture

The project is intentionally designed to reflect real-world backend engineering practices.

 Potential Extensions (Future Work)

React frontend integration (task dashboard)
User profile settings
Task categories / labels
Pagination
Refresh tokens
Role-based authorization

---

 Features at a Glance

- ✔ Secure JWT Authentication  
- ✔ User Registration & Login  
- ✔ BCrypt Password Hashing  
- ✔ Fully Stateless Security Layer  
- ✔ Task CRUD endpoints  
- ✔ User-scoped data isolation  
- ✔ PostgreSQL relational database  
- ✔ Clean and scalable architecture  

---

 Authentication System

Authentication is implemented with **Spring Security 6** and **JWT** tokens.

### Endpoints
- `POST /auth/register` → Register a new user  
- `POST /auth/login` → Authenticate and receive a JWT token  

All remaining endpoints require:


Passwords are hashed using **BCrypt**, ensuring secure credential storage.

---
## 📝 Task API Endpoints

| Method | Endpoint        | Description                            |
|--------|-----------------|----------------------------------------|
| POST   | `/tasks`        | Create a new task                      |
| GET    | `/tasks`        | Get tasks belonging to current user    |
| PUT    | `/tasks/{id}`   | Update an existing task (optional)     |
| DELETE | `/tasks/{id}`   | Delete a task (optional)               |

Each task is **tied to the authenticated user**, ensuring proper authorization.

---

Architecture Overview

src/
└── main/
├── java/com/taskflow
│ ├── model/ → Entity classes (User, Task)
│ ├── repository/ → JPA repositories
│ ├── security/ → JWT provider, filters, config
│ ├── controller/ → REST API endpoints
│ └── service/ → Business logic (Auth + Tasks)
└── resources/
└── application.properties


The architecture follows standard **Spring Boot layered design**, making it scalable and maintainable.

---

## Tech Stack

- **Java 21**  
- **Spring Boot 3.5**  
- **Spring Security 6**  
- **JWT Authentication**  
- **PostgreSQL 16**  
- **JPA / Hibernate**  
- **Lombok**  
- **Maven**  

---

## Running the Project

1. Configure PostgreSQL in `application.properties`:

spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow
spring.datasource.username=postgres
spring.datasource.password=your_password

2. Start the application:
mvn spring-boot:run
3. Test API with Thunder Client or Postman.

---

##  Example Requests

###  Register
```json
POST /auth/register
{
"username": "batuhan",
"password": "123456"
}
Login (returns JWT)
POST /auth/login
{
  "token": "eyJh..."
}
Get Tasks
Authorization: Bearer <token>
[
  {
    "id": 1,
    "title": "My first task",
    "description": "This is a test task",
    "completed": false
  }
]






