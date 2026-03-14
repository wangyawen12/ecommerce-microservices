# Ecommerce Microservices

A Spring Boot microservices project that demonstrates service decomposition, centralized API gateway routing, service discovery, synchronous and asynchronous inter-service communication, JWT authentication, and Redis-backed session control.

## Overview

This project is built as a multi-service ecommerce backend with the following components:

- **api-gateway**  
  Centralized entry point for all client requests. Performs JWT validation and Redis-backed login-state checks before routing traffic to downstream services.

- **eureka**  
  Service registry used for service discovery across microservices.

- **user-service**  
  Handles user registration, login, and logout. Generates JWT tokens and stores login state in Redis.

- **product-service**  
  Manages product data using MongoDB.

- **order-service**  
  Creates and persists orders in MySQL. Calls `inventory-service` synchronously via OpenFeign and publishes order events to Kafka after successful order placement.

- **inventory-service**  
  Checks product stock availability and manages inventory data in MySQL.

- **notification-service**  
  Consumes Kafka order events asynchronously for post-order processing.

## Service Ports

| Service | Port |
|--------|------|
| product-service | 8080 |
| order-service | 8081 |
| inventory-service | 8082 |
| user-service | 8083 |
| notification-service | 8084 |
| api-gateway | 9000 |
| eureka | 8761 |
| MySQL | 3307 |
| MongoDB | 27017 |
| Redis | 6379 |
| Kafka Broker | 9092 |
| Kafka UI | 8086 |

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Cloud
- Spring Security
- Spring Cloud Gateway
- Netflix Eureka
- OpenFeign
- Spring Kafka
- Spring Data JPA
- Spring Data MongoDB
- Spring Data Redis
- MySQL
- MongoDB
- Redis
- Apache Kafka
- Flyway
- Docker
- Maven

## Key Features

- Microservices architecture with independently running services
- Centralized ingress through API Gateway
- Service discovery using Eureka
- JWT-based authentication
- Redis-backed login-state validation
- Logout support with immediate token invalidation
- Synchronous communication via OpenFeign
- Event-driven communication via Kafka
- Persistent storage across MySQL and MongoDB
- Flyway-based schema migration for relational services

## Core Flows

### Authentication and Session Control
- Users register and log in through `user-service`
- `user-service` validates credentials against MySQL
- On successful login, JWT is generated and login state is stored in Redis
- `api-gateway` validates both JWT and Redis-backed session state for protected requests
- Logout removes the Redis login-state entry so existing tokens become invalid immediately

### Order Placement
- Client sends order request through `api-gateway`
- Gateway authenticates the request
- `order-service` checks stock by calling `inventory-service` synchronously via OpenFeign
- If stock is available, the order is saved in MySQL

### Event-Driven Processing
- After a successful order, `order-service` publishes an `OrderPlacedEvent` to Kafka
- `notification-service` consumes the event asynchronously
- This extends the system from purely synchronous microservices to a hybrid synchronous + event-driven architecture

## What This Project Demonstrates

- Building a multi-module Spring Boot microservices system
- Using API Gateway as a centralized security and routing layer
- Applying JWT authentication with Redis-backed session control
- Implementing logout with immediate token invalidation
- Combining synchronous service calls with asynchronous event-driven messaging
- Integrating multiple data stores across services
- Managing relational schema evolution with Flyway

## Future Improvements

- Role-based authorization (USER / ADMIN)
- Refresh token support
- Header propagation of authenticated user identity to downstream services
- Email integration in `notification-service`
- Kafka retry handling and dead-letter queues
- Avro + Schema Registry for stronger event contracts
- Resilience patterns such as retry and circuit breaker
- Distributed tracing and observability
- Kubernetes deployment

## Run the Project

Start the required infrastructure first:

- MySQL
- MongoDB
- Redis
- Kafka
- Kafka UI

Then start the services:

```bash
mvn -pl eureka spring-boot:run
mvn -pl product-service spring-boot:run
mvn -pl inventory-service spring-boot:run
mvn -pl order-service spring-boot:run
mvn -pl user-service spring-boot:run
mvn -pl notification-service spring-boot:run
mvn -pl api-gateway spring-boot:run
