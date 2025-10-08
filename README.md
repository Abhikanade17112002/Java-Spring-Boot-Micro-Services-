# Java Spring Boot Microservices Series ![Project Banner](https://github.com/Abhikanade17112002/Java-Spring-Boot-Micro-Services-/blob/main/Resources/project_banner.png)

---

## 🚀 Table of Contents

1. [Overview](#overview)
2. [Architecture](#architecture)
3. [Entity Relationship Diagram](#entity-relationship-diagram)
4. [Features](#features)
5. [Fault Tolerance](#fault-tolerance)
6. [Tech Stack](#tech-stack)
7. [Screenshots](#screenshots)
8. [Project Timeline](#project-timeline)
9. [How to Run](#how-to-run)
10. [Contributing](#contributing)

---

## 🧩 Overview

This repository contains a complete **Microservices Project** built using **Spring Boot**, **Spring Cloud**, and **Resilience4J**. The series walks through building multiple independent yet connected services like **User**, **Hotel**, and **Rating Services**, including **API Gateway**, **Config Server**, and **Service Discovery**.

### 🎯 Highlights

* Microservice architecture built from scratch
* Service communication via **Feign Client** and **Eureka Discovery Server**
* Centralized configuration using **Spring Cloud Config**
* Resilience & Fault Tolerance using **Resilience4J** (Circuit Breaker, Retry, Rate Limiter)
* API Gateway for routing and authentication

---

## 🏗️ Architecture

![Architecture Diagram](https://github.com/Abhikanade17112002/Java-Spring-Boot-Micro-Services-/blob/main/Resources/architecture_flow.png)

**Flow Explanation:**

1. User → API Gateway → Microservice (User / Hotel / Rating)
2. All services register to **Eureka Server** for service discovery.
3. Configurations are managed by **Config Server**.
4. Fault tolerance implemented using **Resilience4J**.

---

## 🧠 Entity Relationship Diagram

![ER Diagram](https://github.com/Abhikanade17112002/Java-Spring-Boot-Micro-Services-/blob/main/Resources/er_diagram.png)

**Entities:**

* **User:** userId, name, email
* **Hotel:** hotelId, name, location
* **Rating:** ratingId, userId, hotelId, score, feedback

Relationships:

* One User ➜ Many Ratings
* One Hotel ➜ Many Ratings

---

## 🛡️ Fault Tolerance

![Fault Tolerance Diagram](https://github.com/Abhikanade17112002/Java-Spring-Boot-Micro-Services-/blob/main/Resources/circuit_breaker_flow.png)

Implemented using **Resilience4J Modules**:

* 🔁 **Retry** — Reattempt failed calls automatically
* ⚡ **Circuit Breaker** — Prevents cascading failures
* ⏱️ **Rate Limiter** — Restricts excessive requests

---

## ⚙️ Tech Stack

| Category         | Technologies                                    |
| ---------------- | ----------------------------------------------- |
| Backend          | Spring Boot, Spring Cloud, Eureka, Feign Client |
| Config & Gateway | Spring Cloud Config, API Gateway                |
| Database         | MySQL / MongoDB                                 |
| Fault Tolerance  | Resilience4J                                    |
| Communication    | REST, Feign Client                              |
| Build Tool       | Maven                                           |

---


## 🕒 Project Timeline

| Timestamp | Topic                          |
| --------- | ------------------------------ |
| 00:00:00  | Prerequisites of Microservices |
| 00:08:13  | What is Microservices & Why    |
| 31:21     | Creating User Service          |
| 1:19:34   | Full Hotel Microservice        |
| 1:47:11   | Rating Microservice            |
| 2:17:32   | Service Registry Server        |
| 3:43:25   | Feign Client Implementation    |
| 3:57:15   | API Gateway                    |
| 4:43:03   | Config Server                  |
| 5:42:33   | Circuit Breaker                |
| 6:40:18   | Rate Limiter                   |

---

## ⚡ How to Run

1. **Clone the repository:**

   ```bash
   git clone https://github.com/Abhikanade17112002/Java-Spring-Boot-Micro-Services-.git
   ```
2. **Navigate to project folder:**

   ```bash
   cd Java-Spring-Boot-Micro-Services-
   ```
3. **Build and Run:**

   ```bash
   mvn spring-boot:run
   ```
4. **Access Services:**

   * Eureka Server: `http://localhost:8761`
   * API Gateway: `http://localhost:8080`

---

## 🤝 Contributing

Contributions are welcome! Fork the repo and open a PR 🚀

---

### 🧑‍💻 Author

**Abhishek Rangnath Kanade**
*MERN & Java Spring Boot Developer*
📍 Pune, India
🔗 [LinkedIn](https://www.linkedin.com/in/abhikanade17112002)

---

> *This repository showcases a production-grade microservices system covering key enterprise-level concepts like service discovery, centralized configuration, and fault tolerance.*
