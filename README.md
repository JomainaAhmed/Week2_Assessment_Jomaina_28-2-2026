# Advanced Java Assessment (Week 2)

# Week 2 – Spring Boot Employee API

## Description
This assessment involves building a **RESTful Employee Management API using Spring Boot**.  
The system allows administrators to manage employee records using REST endpoints.

## Technologies Used
- Spring Boot
- Spring Data JPA
- REST APIs
- Maven
- PostgreSQL

## Employee Entity

- id
- name
- phone
- email
- salary
- department

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| POST | `/api/employees` | Add new employee |
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees?id=10` | Retrieve employee by ID |
| DELETE | `/api/employees?id=10` | Delete employee |
| GET | `/api/employees/search?name=Ravi` | Search by name |
| GET | `/api/employees/search?department=Testing` | Search by department |
| GET | `/api/employees/search?phone=9876543210` | Search by phone |
| GET | `/api/employees/search?email=ravi@gmail.com` | Search by email |

## Optional Features
- Update employee details
- Search employees within salary range
- Find employee with maximum salary
- Find employee with minimum salary

---

# How to Run the Projects

## Clone the Repository
```bash
git clone https://github.com/your-username/repository-name.git
```

## Navigate to the Project
```
cd repository-name
```

## Build the Project
```
mvn clean install
```

## Run the Application
```
mvn spring-boot:run
```

---
