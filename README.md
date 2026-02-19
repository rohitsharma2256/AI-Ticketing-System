# 🤖 AI-Powered Smart Ticketing & Issue Resolution System

A production-style Helpdesk Ticket Management backend built using Spring Boot and PostgreSQL with AI-powered ticket classification and automated response generation.

This system allows users to create support tickets, automatically categorizes issues, assigns the appropriate support team, and generates intelligent responses.

Designed with real-world backend architecture and industry best practices.

---

## 🚀 Features

### 🎫 Ticket Management
- Create support tickets
- Automatic ticket status tracking
- Priority detection (Low / Medium / High)
- Automatic support team assignment

### 🤖 AI-Based Processing
- Ticket category prediction
- Priority prediction
- Team routing
- Auto-generated response suggestion

### 👤 User Management
- Create users
- Associate tickets with users
- Structured role-based model

### 🧱 Clean Backend Architecture
- Controller layer
- Service layer
- Repository layer
- DTO pattern
- Global exception handling

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Lombok  
- REST APIs  

---

## 📡 API Endpoints

### Create User
POST `/api/users`

Example request:
```json
{
  "name": "Rohit",
  "email": "rohit@test.com",
  "role": "USER"
}

Create Ticket

POST /api/tickets

Example request:
{
  "title": "Payment Failed",
  "description": "Money deducted but transaction failed",
  "userId": 1
}

🎯 Use Cases

Customer support systems

IT helpdesk automation

SaaS product support

E-commerce issue management


🔮 Future Enhancements

Real AI model integration

JWT authentication

Role-based authorization

Email notifications

Admin dashboard

Docker deployment

React frontend


👨‍💻 Author

Rohit Rajendra Sharma
Java Backend Developer

