# Task Manager Backend API

A Spring Boot REST API for managing tasks and user authentication.

## 🔗 Frontend & Demo

- **Live Here :** https://managertaskk.netlify.app/login
- **Frontend Repository:** https://github.com/sudhirskp/taskManager_frontend
- **Demo Video:** Visit the frontend repository for the demo video link
- **Backend Live URL:** https://taskmanager-15hk.onrender.com/

## ✨ Features

- User registration and login with password encryption
- Create, update, list, and delete tasks
- Task status management (TODO, IN_PROGRESS, DONE)
- H2 database for local development
- CORS enabled for frontend integration
- Global exception handling for clean error responses

## 🛠️ Tech Stack

- **Runtime:** Java 21
- **Framework:** Spring Boot 4.0.6
- **ORM:** Spring Data JPA with Hibernate 7.2
- **Database:** H2 (dev) / MySQL (production-ready)
- **Build Tool:** Maven
- **Security:** Spring Security for password encoding
- **API:** RESTful endpoints with Spring Web MVC

## 🚀 Quick Start

### Prerequisites

- Java 21 or higher
- Maven 3.9+

### Local Setup

1. **Clone and navigate to the project:**

```powershell
cd taskManager/taskManager
```

2. **Build and run tests:**

```powershell
.\mvnw test
```

3. **Run the application:**

```powershell
.\mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## 📚 API Endpoints

### Authentication

#### Register a new user
```http
POST /api/auth/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "secret123"
}
```

**Response (201):**
```json
"User registered successfully"
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "secret123"
}
```

**Response (200):**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john@example.com",
  "password": "hashed_password"
}
```

### Tasks

#### Create a task
```http
POST /api/tasks
Content-Type: application/json

{
  "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "status": "TODO",
  "userId": 1
}
```

**Response (201):**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "status": "TODO"
}
```

#### Get tasks by user
```http
GET /api/tasks/1
```

**Response (200):**
```json
[
  {
    "id": 1,
    "title": "Buy groceries",
    "description": "Milk, eggs, bread",
    "status": "TODO"
  }
]
```

#### Update a task
```http
PUT /api/tasks/1
Content-Type: application/json

{
  "title": "Buy groceries",
  "description": "Updated list",
  "status": "IN_PROGRESS",
  "userId": 1
}
```

**Response (200):**
```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Updated list",
  "status": "IN_PROGRESS"
}
```

#### Delete a task
```http
DELETE /api/tasks/1
```

**Response (200):**
```json
"Task deleted successfully"
```

## 🗂️ Project Structure

```
src/
├── main/
│   ├── java/com/indpro/taskManager/
│   │   ├── Controller/       # API endpoints
│   │   ├── Service/          # Business logic
│   │   ├── Repository/       # Database access
│   │   ├── Entity/           # JPA entities
│   │   ├── DTO/             # Data transfer objects
│   │   ├── config/          # CORS and security config
│   │   └── exp/             # Exception handling
│   └── resources/
│       └── application.properties
└── test/                     # Unit and integration tests
```

## ⚙️ Configuration

### H2 Database (Development - Default)

```properties
spring.datasource.url=jdbc:h2:mem:skpGroup
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

Access H2 console at: `http://localhost:8080/h2-console`

### MySQL Database (Optional)

To use MySQL instead, uncomment and configure in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:2209/taskmanager
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## 📋 Task Status Values

Tasks can have one of three statuses:

- `TODO` - Not started
- `IN_PROGRESS` - Currently being worked on
- `DONE` - Completed

## 🐳 Docker

A Dockerfile is included for containerization. Build and run:

```powershell
docker build -t taskmanager .
docker run -p 8080:8080 taskmanager
```

## 📝 Notes

- **Data Persistence:** H2 in-memory database resets on application restart. Use MySQL for persistent storage.
- **CORS:** Currently allows all origins. Configure in `src/main/java/.../config/ConfigCORS.java` for production.
- **Password Security:** Passwords are encrypted using Spring Security.
- **Frontend:** This backend is built to work with the React frontend at https://managertaskk.netlify.app/login

## 📄 License

MIT


