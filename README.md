# AcmePlex

AcmePlex is a full-stack application that includes a Spring Boot backend and a Vue.js frontend. The backend handles API requests, while the frontend provides a user interface for interacting with the application.

## Project Structure

The project is organized as follows:

- **/backend**: Contains the Spring Boot backend application.
- **/frontend**: Contains the Vue.js client application.

## Requirements

Before running the project, ensure you have the following installed:

- **Java 11+** (for running Spring Boot)
- **Node.js** (for running the Vue.js frontend)
- **MySQL** (or a compatible database)

## Setup Instructions

Follow these steps to set up and run both the backend and frontend of the application.

### 1. Set Up MySQL Database

Make sure MySQL is installed and running. You need to create a database and update the Spring Boot configuration with your MySQL credentials.

1. Create a MySQL database:
    ```sql
    CREATE DATABASE acmeplex_db;
    ```

2. Update your MySQL username and password in the backend configuration:
    - Open `backend/src/main/resources/application.properties`
    - Modify the following properties to match your MySQL credentials:
    ```properties
    spring.datasource.username=your_mysql_username   # Change to your MySQL username
    spring.datasource.password=your_mysql_password   # Change to your MySQL password
    ```

### 2. Backend Setup (Spring Boot)

Navigate to the `backend` folder and follow these steps to set up and run the Spring Boot backend:

1. **Build the backend** (using Maven):
    ```bash
    cd backend
    ./mvnw clean install
    ```

2. **Run the Spring Boot application**:
    ```bash
    ./mvnw spring-boot:run
    ```

    - This will start the backend server on `http://localhost:8080`.

### 3. Frontend Setup (Vue.js)

Navigate to the `frontend` folder and follow these steps to set up and run the Vue.js frontend:

1. **Install dependencies**:
    ```bash
    cd frontend
    npm install
    ```

2. **Run the Vue.js development server**:
    ```bash
    npm run serve
    ```

    - This will start the frontend server on `http://localhost:3000`.

### 4. Access the Application

- The Spring Boot backend API will be available at `http://localhost:8080`.
- The Vue.js frontend will be available at `http://localhost:3000`.
