# EmployeeManagement
An Employee Management System using Spring Boot 

✅ Setting up Spring Boot in VS Code
✅ Creating a basic CRUD API for employee management
✅ Using Spring Boot with JPA and H2 (in-memory database)

Step 1: Prerequisites
Before starting, ensure you have the following installed:
1️⃣ Java JDK 17+ → Download JDK
2️⃣ VS Code → Download VS Code
3️⃣ Spring Boot Extension Pack (Install in VS Code)
4️⃣ Maven (Verify with mvn -v in the terminal)

Step 2: Create a New Spring Boot Project

Open VS Code
Press Ctrl + Shift + P and type:
👉 Spring Boot: Create a new Spring Boot project
Select "Maven" as the build tool
Select Dependencies:
Spring Web
Spring Data JPA
H2 Database
Lombok
Choose Java version: 17+
Set project name: employee-management
Click "Finish" → Wait for the project to generate

Step 3: Configure application.properties

Step 4: Create Employee Entity

Step 5: Create Employee Repository

Step 6: Create Employee Service

Step 7: Create Employee Controller

Step 8: Run the Application
1️⃣ Open VS Code Terminal
2️⃣ Run the application using:
mvn spring-boot:run

3️⃣ Access API Endpoints in Postman or Browser:

Create Employee → POST http://localhost:8080/employees
Get All Employees → GET http://localhost:8080/employees
Get Employee by ID → GET http://localhost:8080/employees/1
Update Employee → PUT http://localhost:8080/employees/1
Delete Employee → DELETE http://localhost:8080/employees/1
H2 Database Console → http://localhost:8080/h2-console (Use JDBC URL: jdbc:h2:mem:employee_db)

Step 9: Testing (Optional)
📁 Create src/test/java/com/example/employee/EmployeeTests.java
Write unit tests using JUnit and Mockito for EmployeeService.

This Employee Management System covers the CRUD operations with Spring Boot, JPA, and H2. 🚀
