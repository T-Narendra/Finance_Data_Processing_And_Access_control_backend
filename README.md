# Finance_Data_Processing_And_Access_control_backend

# 📌 Objective

This project is a backend system for managing financial records with role-based access control.
It demonstrates API design, data modeling, business logic, and access control using Spring Boot and MySQL.

---

🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- Maven

---

# ⚙️ Setup Instructions

1. Clone the repository:

git clone <your-repo-link>

2. Open the project in IDE (STS / IntelliJ)

3. Configure MySQL in "application.properties":

spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

4. Run the application:

FinanceDashboardApplication.java

5. Server will start at:

http://localhost:8080

---

🗄️ Database

- Database: MySQL
- Tables:
  - "record" → stores financial transactions
  - "user" → stores user details (optional for role handling)

---

# 📊 Features

# ✔ Financial Records Management

- Create records
- View records
- Update records
- Delete records

# ✔ Dashboard Summary

- Total Income
- Total Expenses
- Net Balance

# ✔ Role-Based Access Control

Role| Permissions
VIEWER| Can only view records
ANALYST| Can view records + summary
ADMIN| Full access (create, update, delete)

---

# 🔐 Role Handling

Role is passed using request header:

role: ADMIN / ANALYST / VIEWER

---

# 📡 API Endpoints

---

# 👤 User APIs

# ➤ Create User

POST /users

Request Body:

{
  "name": "Admin User",
  "email": "admin@test.com",
  "password": "123",
  "role": "ADMIN",
  "status": "ACTIVE"
}

---

# 💵 Record APIs

# ➤ Create Record (ADMIN only)

POST /records

Headers:

role: ADMIN

Body:

{
  "amount": 5000,
  "type": "INCOME",
  "category": "Salary",
  "date": "2025-04-01",
  "note": "Monthly salary"
}

---

# ➤ Get All Records (All roles)

GET /records

Response:

[
  {
    "id": 1,
    "amount": 5000,
    "type": "INCOME",
    "category": "Salary",
    "date": "2025-04-01",
    "note": "Monthly salary"
  }
]

---

# ➤ Update Record (ADMIN only)

PUT /records/{id}

---

# ➤ Delete Record (ADMIN only)

DELETE /records/{id}

---

# 📈 Dashboard APIs

# ➤ Get Summary (ANALYST / ADMIN)

GET /dashboard/summary

Response:

{
  "income": 5000,
  "expense": 2000,
  "balance": 3000
}

---

# ❌ Error Handling

- 403 Forbidden → Unauthorized role
- 404 Not Found → Record not found
- 400 Bad Request → Invalid input

---

# 📸 Screenshots

(Add your Postman screenshots here)

- Create record
- Get records
- Access denied (viewer trying POST)
- Dashboard summary

---

# 💡 Design Note

- Role-based access control is implemented using request headers
- Focus is on backend logic and simplicity as per assignment
- Clean layered architecture (Controller → Service → Repository)

---

# 🎯 Conclusion

This project demonstrates:

- Clean backend architecture
- REST API design
- Role-based authorization
- Data processing and aggregation

---
