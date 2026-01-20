# Task Management API

A simple RESTful API for managing users and their tasks. Built with Spring Boot, the service exposes endpoints to create and manage users and tasks, update task status, and list tasks belonging to a user. The API is documented with OpenAPI (Swagger).

## Features
- Create and manage users
- Create tasks and assign them to users
- Update task status
- Retrieve tasks for a specific user
- OpenAPI/Swagger documentation

## Technology stack
- Java 17+ (recommended)
- Spring Boot (Web, Data JPA)
- Hibernate (via Spring Data JPA)
- ModelMapper (DTO -> Entity mapping)
- Lombok (boilerplate reduction)
- springdoc-openapi / Swagger (OpenAPI 3)
- JUnit (tests)
- Build: Maven (or Maven Wrapper if present)
- Database: any JDBC-compatible database (H2, PostgreSQL, MySQL, etc.)

## Project structure (high level)
- task-api/src/main/java/... — Spring Boot application code (entities, controllers, services, repositories, config)
- task-api/src/test/... — tests

## Prerequisites
- Java 17+ installed
- Maven (or use the included Maven wrapper `./mvnw` if present)
- A database (or use an in-memory DB for development such as H2). Configure connection in `application.properties` or `application.yml`.

## How to build

From the repository root:

Using Maven wrapper (if present)
./mvnw -f task-api clean package

Or using installed Maven
mvn -f task-api clean package

This will produce an executable JAR under `task-api/target/` (for example `task-api/target/task-api-<version>.jar`).

## How to run

Option 1 — Run with Maven
cd task-api
./mvnw spring-boot:run
# or
mvn spring-boot:run

Option 2 — Run the packaged JAR
java -jar task-api/target/task-api-*.jar

The application runs by default on port 8080 (http://localhost:8080) unless another port is configured via `server.port` in your application configuration or environment variable.

If using a relational database, make sure to set the appropriate JDBC URL, username and password in `application.properties` (or via environment variables). For quick development you can configure H2 or enable Spring Boot's default in-memory DB.

## API Endpoints (examples)
The repository exposes typical user and task endpoints. Examples discovered in the codebase include:

- POST /tasks
  - Create a task (request body: CreateTask DTO)
- GET /users/{id}/tasks
  - Retrieve all tasks for a user
- PUT /tasks/{id}/status
  - Update a task's status (request body: UpdateTaskStatus DTO)

Use the Swagger UI (see below) to explore the full contract (request/response schemas, validation, example payloads).

Example: Create a task (curl)
curl -X POST "http://localhost:8080/tasks" \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy groceries","description":"Milk, eggs","status":"PENDING","userId":1}'

Example: Update task status
curl -X PUT "http://localhost:8080/tasks/1/status" \
  -H "Content-Type: application/json" \
  -d '{"taskStatus":"COMPLETED"}'

## How to access Swagger UI

Once the application is running, the OpenAPI JSON and Swagger UI are typically available at:

- OpenAPI JSON:
  - http://localhost:8080/v3/api-docs

- Swagger UI (depending on springdoc version):
  - http://localhost:8080/swagger-ui.html
  - or http://localhost:8080/swagger-ui/index.html

Open the Swagger UI URL in your browser to interact with the API and view request/response models.
