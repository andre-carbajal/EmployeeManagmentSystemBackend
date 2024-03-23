# Employee Management System

This is a simple Employee Management System built with Java, Spring Boot, and MySQL. The application provides a RESTful API for managing employees in a company.

## Technologies Used

- Java
- Spring Boot
- MySQL
- Maven

## Features

The application provides the following features:

- Get all employees
- Add a new employee
- Get an employee by ID
- Update an employee by ID
- Delete an employee by ID

## Setup

### Prerequisites

- Java 17 or higher
- Maven
- MySQL

### Installation

1. Clone the repository
2. Navigate to the project directory
3. Update the `src/main/resources/application.yml` file with your MySQL credentials
4. Have a MySQL server running with an scheme called `employeemanagersystem`
5. Run the application using Maven:

```bash
mvn spring-boot:run
```

The application will start running at http://localhost:8080.

### API Documentation
The API documentation is available at http://localhost:8080/documentation.

### API Endpoints

- GET /api/v1/employees: Get all employees
- POST /api/v1/employees: Add a new employee
- GET /api/v1/employees/{id}: Get an employee by ID
- PUT /api/v1/employees/{id}: Update an employee by ID
- DELETE /api/v1/employees/{id}: Delete an employee by ID

### Frontend

The frontend for this application is available at this [link](https://github.com/andre-carbajal/EmployeeManagmentSystemFrontend)
