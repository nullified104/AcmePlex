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
- **MySQL** (for the database)

## Setup Instructions

Follow these steps to set up and run both the backend and frontend of the application.

---

### 1. Set Up MySQL Database

Make sure MySQL is installed and running. You need to create a database and configure your backend to connect to it.

1. Create a MySQL database:
    ```sql
    CREATE DATABASE acmeplex_db;
    ```

2. Import the database schema and sample data from the `Group10.sql` file:
    - Locate the `Group10.sql` file in the project directory.
    - Run the following command in your terminal (replace placeholders as needed):
      ```bash
      mysql -u root -p acmeplex_db < path_to_project/Group10.sql
      ```
    - Alternatively, use a MySQL client like MySQL Workbench to import the file.

3. Note the database name (`acmeplex_db`), your MySQL username, and your MySQL password. These will be used to configure the backend.

---

### 2. Backend Setup (Spring Boot)

Navigate to the `backend` folder and follow these steps to set up and run the Spring Boot backend:

1. **Create a `.env` file**:
    - In the `backend` root directory, create a file named `.env`.
    - Add the following properties, replacing the placeholders with your MySQL credentials:
      ```env
      DATABASE_URL=jdbc:mysql://localhost:3306/acmeplex_db?useSSL=false
      DB_USERNAME=root
      DB_PASSWORD=your_mysql_password
      ```

2. **Ensure the `.env` file is loaded**:
    - The application is configured to use the `.env` file, so no additional changes are required.

3. **Build the backend** (using Maven):
    ```bash
    cd backend
    ./mvnw clean install
    ```

4. **Run the Spring Boot application**:
    - You can run the backend server directly from IntelliJ IDEA:
      1. Open the `backend` folder in IntelliJ IDEA.
      2. Navigate to the `BackendApplication` main class.
      3. Right-click the file and select **Run** to start the application.
    - Alternatively, you can run the server from the terminal:
      ```bash
      ./mvnw spring-boot:run
      ```

---

### 3. Run the Frontend

In a separate terminal window, navigate to the `frontend` folder and run the following commands:

1. **Install dependencies**:
    ```bash
    npm install
    ```

2. **Start the development server**:
    ```bash
    npm run serve
    ```

---

By following these steps, you should have both the backend and frontend running successfully.
