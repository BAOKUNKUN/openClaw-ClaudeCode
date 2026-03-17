# Test Spring Boot

Simple Spring Boot application with a test API endpoint.

## Project Structure

```
test-spring-boot/
├── pom.xml
└── src/main/
    ├── java/com/example/demo/
    │   ├── DemoApplication.java
    │   └── controller/
    │       └── TestController.java
    └── resources/
        └── application.properties
```

## API Endpoint

- `GET /api/test` - Returns "Hello World"

## Running Tests

```bash
mvn test
```

## Running the Application

```bash
mvn spring-boot:run
```

Access at: http://localhost:8080/api/test
