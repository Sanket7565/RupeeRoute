# 💼 RupeeRoute

**A Real-Time UPI-like Fintech Payment System Using Spring Boot Microservices**

RupeeRoute is a modular and secure fintech backend inspired by UPI systems. Built with Spring Boot microservices architecture, it is designed for scalability, observability, and production-ready deployments.

---

## 🚀 Tech Stack

- **Backend Framework:** Spring Boot
- **Architecture:** Layered (Controller, Service, Repository, DTO, Entity)
- **Communication:** REST + OpenFeign (sync), Kafka (async)
- **Service Discovery:** Eureka
- **Gateway:** Spring Cloud Gateway
- **Database:** MySQL (per service)
- **Security:** OAuth2 + JWT
- **Observability:** Micrometer, Prometheus, Grafana *(optional)*
- **Containerization:** Docker + Docker Compose

---

## 🧠 Core Microservices

### 1. **Auth Service** (Port: `8081`)
Handles user authentication, registration, and JWT management.

- Endpoints:
  - `POST /auth/register`
  - `POST /auth/login`
  - `GET /auth/validate`

### 2. **User Service** (Port: `8082`)
Manages user profiles, VPAs, and linked bank accounts.

- Endpoints:
  - `GET /users/{id}`
  - `PUT /users/{id}`
  - `POST /users/link-account`
  - `GET /users/vpa/{vpa}`

### 3. **Transaction Service** (Port: `8083`)
Processes money transfers and requests.

- Endpoints:
  - `POST /transactions/send`
  - `POST /transactions/request`
  - `GET /transactions/user/{userId}`

### 4. **Ledger Service** (Port: `8084`)
Maintains transaction histories and account balances.

- Endpoints:
  - `POST /ledger/entry`
  - `GET /ledger/user/{userId}`

### 5. **Fraud Detection Service** (Port: `8085`)
Flags suspicious activities based on heuristics.

- Endpoints:
  - `GET /fraud/user/{userId}`
  - `GET /fraud/txn/{txnId}`

### 6. **Notification Service** (Port: `8086`)
Handles email and SMS alerts for events.

- Endpoints:
  - `POST /notify/email`
  - `POST /notify/sms`

---

## 🌐 API Gateway (Port: `8080`)

Central entry point for all client traffic. Uses Spring Cloud Gateway for routing.

Example config:
```yaml
spring.cloud.gateway.routes:
  - id: auth-service
    uri: lb://AUTH-SERVICE
    predicates:
      - Path=/auth/**
  - id: user-service
    uri: lb://USER-SERVICE
    predicates:
      - Path=/users/**
