# Book Library Management Microservice

## Overview

The Book Management Microservice is a Spring Boot application designed to manage a library system. This microservice provides RESTful endpoints for performing CRUD (Create, Read, Update, Delete) operations on books. It utilizes a relational database for data persistence and includes Swagger for API documentation.

## Features

- **CRUD Operations**: Create, Read, Update, and Delete books.
- **Data Persistence**: H2
- **API Documentation**: Generated with Swagger
- **Unit Tests**: Basic unit testing included.

## Technologies Used

- **Spring Boot**: Framework for building the application.
- **Spring Data JPA**: For data access and persistence.
- **H2 Database**: In-memory database used for development.
- **Swagger**: For API documentation.
- **JUnit**: For unit testing.

## API Documentation
The API documentation is available at http://localhost:8080/swagger-ui.html.

## Setup and Installation

### Prerequisites

- JDK 17 or higher
- Maven

### Clone the Repository

```bash
git clone <repository-url>
cd <repository-directory>


****** API Endpoints ***********
The following endpoints are available:

# Get All Books
URL: /getBook
Method: GET
Response: 200 OK with a list of books or 404 Not Found if no books are present.

# Get Book By ISBN
URL: /getBookByIsbn/{isbn}
Method: GET
Path Variable: isbn - The ISBN of the book to retrieve.
Response: 200 OK with the book details or 404 Not Found if the book does not exist.

# Add New Book
URL: /addBook
Method: POST
Request Body: Book object (JSON format)
Response: 201 Created with the added book details.

# Add All Books
URL: /addallbook
Method: POST
Request Body: List of Book objects (JSON format)
Response: 201 Created with the list of added books.

# Delete Book By ISBN
URL: /Deletebyisbn/{isbn}
Method: DELETE
Path Variable: isbn - The ISBN of the book to delete.
Response: 204 No Content if deletion is successful or 404 Not Found if the book does not exist.

# Update Book By ISBN
URL: /updateByIsbn/{isbn}
Method: PUT
Path Variable: isbn - The ISBN of the book to update.
Request Body: Book object with updated details (JSON format)
Response: 200 OK with the updated book details or 500 Internal Server Error in case of issues.



