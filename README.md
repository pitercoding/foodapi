# 🍽️ FoodAPI

A simple REST API built with **Spring Boot**, **Java 21**, and **H2 Database**, created for learning purposes. It is a CRUD, allowing you to *register*, *list*, *update*, and *delete* food items.

## 🎯 Project Goals
The main goal of this project is to review and solidify the fundamentals of creating a REST API using **Spring Boot**.  

This includes:

- Understanding the structure of a Spring Boot application
- Connecting the API to an **H2 in-memory database**
- Implementing basic CRUD operations
- Sending and handling simple HTTP requests
- Practicing clean architecture with Controller, Service, Repository, and Model layers

This project serves as a hands-on study tool to reinforce core backend development concepts.

## 🚀 Features
- Create food items
- Retrieve all food items
- Update food items by ID
- Delete food items
- In-memory database with H2
- Organized layered architecture (Controller, Service, Repository, Model)

## 🛠️ Technologies Used
- **Java 21**
- **Spring Boot 4**
  - Spring Web MVC
  - Spring Data JPA 
  - H2 Console
- **Maven**
- **Flyway** (configured, migrations optional)
- **H2 Database**

## 📁 Project Structure
```css
src/main/java/com/example/foodapi
│
├── controller
│   └── FoodController.java
│
├── model
│   └── Food.java
│
├── repository
│   └── FoodRepository.java
│
└── service
    └── FoodService.java
```

## ⚙️ Configuration (application.yml)
```yml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: pitercoding
    password:
  h2:
    console:
      enabled: true
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
  flyway:
    enabled: true
```

## 🔗 H2 Console
Accessible at:
```bash
  http://localhost:8080/h2-console
```

| Field         | Value              |
|:--------------|:-------------------|
| **JDBC URL**  | jdbc:h2:mem:testdb |
| **User**      | pitercoding |
| **Password**      | (empty) |

## ▶️ How to Run the Project

**Using Maven**
```bash
  mvn spring-boot:run
```

**Build the application**
```bash
  mvn clean install
```

API base URL:
```arduino
http://localhost:8080
```

## 📚 API Endpoints
**Base path**: `/food`

### ➕ Create Food
**POST** `/food`

Request Body:
```json
{
  "name": "Banana",
  "expirationDate": "2024-12-31",
  "quantity": 6
}
```

### 📄 Get All Foods
**GET** `/food`

Response:
```json
[
  {
    "id": 1,
    "name": "Banana",
    "expirationDate": "2024-12-31",
    "quantity": 6
  }
]
```

### ✏️ Update Food
**PUT** `/food/{id}`

Request Body:
```json
{
  "name": "Banana Nanica",
  "expirationDate": "2025-01-10",
  "quantity": 8
}
```

### 🗑️ Delete Food
**DELETE** `/food/{id}`

Response: `204 No Content`

## 🧱 Food Model
```java
@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate expirationDate;
    private Integer quantity;

    // Getters, setters, constructors...
}
```

## 📌 Next Improvements (Optional)
- Add DTOs and mappers (MapStruct)
- Add request validation (`@NotNull`, `@Size`, etc.)
- Add global exception handler (`@ControllerAdvice`)
- Implement Swagger/OpenAPI documentation
- Add JWT authentication
- Add unit and integration tests

## 🧑‍💻 Author

**Piter Gomes** – **Computer Science Student** (5th semester) and **Full-Stack Developer**.

📧 [**E-mail**](mailto:piterg.bio@gmail.com) | 💼 [**LinkedIn**](https://www.linkedin.com/in/piter-gomes-4a39281a1/) | 💻 [**GitHub**](https://github.com/pitercoding) | 🌐 [**Portfolio**](https://portfolio-pitergomes.vercel.app/)

---