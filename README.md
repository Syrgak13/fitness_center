🏋️‍♂️ Fitness Center Management System
This is a backend application built with Spring Boot for managing a fitness center. It includes user registration, login (email and social login), JWT-based authentication, and API documentation with Swagger.

📁 Technologies Used
Java 17

Spring Boot

Spring Security

JWT (JSON Web Tokens)

OAuth2 (Google login)

PostgreSQL

Spring Data JPA

Swagger / OpenAPI

Lombok

🚀 Features
User registration (with roles like ADMIN, USER)

Email & password login

Google OAuth2 login

Secure JWT token generation & validation

Role-based access control

Swagger UI for API testing

API protection with security filters

🔐 Security Setup
✅ 1. Authentication & Authorization
Email/password login uses Spring Security + JWT.

Social login via Google OAuth2.

JWT Token is generated upon successful login and must be sent in the header for protected endpoints.

✅ 2. JWT Token Flow
User logs in with email/password or Google.

Server returns an Access Token (JWT).

User must include this token in requests:

Authorization: Bearer <your_token_here>
✅ 3. Roles & Protected Endpoints
Endpoints are restricted by user roles.

For example: /api/admin/** → requires ROLE_ADMIN

JWT is parsed and validated in every request via a security filter.

✅ 4. Spring Security Configuration
Custom security filter handles token extraction & user authentication.

CSRF disabled for stateless API.

Public paths: /api/auth/**, /swagger-ui/**, /v3/api-docs/**

All other paths are protected.

🔍 How to Test the Security
🔨 1. Run the App
Make sure PostgreSQL is running. Then run:

./mvnw spring-boot:run
🔐 2. Register a User
Use Postman or Swagger:


POST /api/auth/register
Request Body:
{
  "email": "user@example.com",
  "password": "yourpassword",
  "fullName": "John Doe"
}
🔐 3. Login to Get JWT Token
POST /api/auth/login
Request Body:

{
  "email": "user@example.com",
  "password": "yourpassword"
}
Response:
{
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
🔐 4. Use JWT to Access Protected Endpoints
Set the header in Swagger or Postman:
Authorization: Bearer <your_token_here>
Example:

GET /api/user/profile
🔐 5. Test Google OAuth2
Visit:

http://localhost:8080/oauth2/authorization/google
After login, it will redirect with a token.

🧪 API Documentation
Swagger UI is available at:
http://localhost:8080/swagger-ui/index.html
🧠 Notes
Passwords are encrypted using BCrypt.

Tokens expire after a configurable time (set in application.yml).

Admin accounts can be manually inserted into the DB for testing purposes.
