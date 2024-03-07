## 🚀 Kafka Consumer Spring Boot Application

This is a simple Spring Boot application that consumes messages from a Kafka topic and saves them to a MySQL database.

### 🛠️ Technologies

- Java 17
- Spring Boot
- Kafka
- MySQL
- Docker
- Docker Compose
- Lombok
- MapStruct
- Swagger
- JUnit 5

### 🚀 Run the application

It is necessary to have Docker and Docker Compose installed on your machine.

```bash
docker-compose up -d
```

The application will be available at [http://localhost:8081](http://localhost:8081).

### 📦 Kafka Producer

## Bonus message

```json
{
  "bonusType": "WelcomeBonus",
  "bonusCode": "WELCOME2023",
  "bonusStatus": "ACTIVE",
  "bonusAmount": "200",
  "bonusCurrency": "USD",
  "createdAt": "2023-01-01T00:00:00Z",
  "lastModifiedTime": "2023-02-01T00:00:00Z",
  "extraDetails": {
    "extraDetails1": "First deposit bonus",
    "extraDetails2": "Valid until 31/12/2023",
    "extraDetails3": "Applies to new users only"
  }
}
```

### Run Just Kafka services
delete orphan docker containers
```Bash
docker-compose down --remove-orphans
```


```bash
docker-compose -f docker-compose.kafka.yml up -d
```

Kafka can be accessed at `localhost:9092`, also available via the Kafka UI at http://localhost:8080/.

### 📖 Swagger API Documentation

🔍 Access the OpenAPI documentation to explore and test the API endpoints:

- Swagger UI: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
