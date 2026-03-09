# GraphQL Learning Application

A comprehensive Spring Boot GraphQL application demonstrating inventory management with modern GraphQL best practices.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Quick Start](#quick-start)
- [API Documentation](#api-documentation)
- [Architecture](#architecture)
- [Database](#database)
- [Technologies](#technologies)

## 🎯 Overview

This project is a learning application that demonstrates how to build a GraphQL API using Spring Boot. It provides a complete example of creating, querying, and managing inventory items through GraphQL endpoints.

**Access the GraphQL Interface:**
```
http://localhost:8080/graphiql
```

## ✨ Features

- ✅ **GraphQL Queries** - Retrieve all items or find items by ID
- ✅ **GraphQL Mutations** - Create new items in the inventory
- ✅ **Spring Data JPA** - Seamless database integration
- ✅ **H2 In-Memory Database** - Easy setup and testing
- ✅ **GraphiQL Interface** - Interactive API exploration
- ✅ **Three-Tier Architecture** - Clean separation of concerns
- ✅ **Comprehensive JavaDoc** - Full code documentation
- ✅ **Spring Boot DevTools** - Hot reload during development

## 🚀 Quick Start

### Prerequisites

- **Java 17** or higher
- **Gradle 8.0** or higher

### Build and Run

```bash
# Clone or navigate to the project
cd /path/to/graphQL-Learning

# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### Access Points

| Interface | URL |
|-----------|-----|
| **GraphQL API** | http://localhost:8080/graphql |
| **GraphiQL UI** | http://localhost:8080/graphiql |
| **H2 Console** | http://localhost:8080/h2-console |

## 📚 API Documentation

### Data Model

#### Item Object

| Field | Type | Description |
|-------|------|-------------|
| `itemId` | Long | Unique identifier (Primary Key) |
| `name` | String | Item name |
| `description` | String | Item description |
| `price` | Double | Item price |
| `quantity` | Integer | Stock quantity |
| `category` | String | Product category |

#### User Object

| Field | Type | Description |
|-------|------|-------------|
| `userId` | Integer | Unique identifier (Primary Key) |
| `username` | String | Unique username for login authentication |
| `email` | String | User's email address for communication |
| `password` | String | Encrypted password for secure authentication |

**Security Note:** Passwords should always be encrypted using a secure hashing algorithm (e.g., bcrypt) before persisting to the database.

### Entity Relationships

The application currently manages two independent entities:

| Entity | Purpose | Primary Key |
|--------|---------|------------|
| **Item** | Inventory item management | itemId (Long) |
| **User** | User account and authentication | userId (Integer) |

Both entities are stored in an H2 in-memory database and can be extended with relationships (e.g., One-to-Many, Many-to-Many) as needed.

### GraphQL Queries

#### 1. Find All Items

Retrieves all items from the inventory.

```graphql
query {
  findAllItems {
    itemId
    name
    price
    category
  }
}
```

**Response:**
```json
{
  "data": {
    "findAllItems": [
      {
        "itemId": 101,
        "name": "Laptop",
        "price": 75000.50,
        "category": "Electronics"
      }
    ]
  }
}
```

#### 2. Find Item by ID

Retrieves a specific item by its unique identifier.

```graphql
query {
  findItemByID(id: 101) {
    itemId
    name
    description
    price
  }
}
```

**Parameters:**
- `id` (Long, Required): The item ID to retrieve

**Response:**
```json
{
  "data": {
    "findItemByID": {
      "itemId": 101,
      "name": "Laptop",
      "description": "Gaming Laptop",
      "price": 75000.50
    }
  }
}
```

### GraphQL Mutations

#### Create Item

Creates a new item in the inventory.

```graphql
mutation {
  createItem(
    itemId: 101
    name: "Laptop"
    description: "Gaming Laptop"
    price: 75000.50
    quantity: 5
    category: "Electronics"
  ) {
    itemId
    name
    description
    price
    quantity
    category
  }
}
```

**Parameters:**
- `itemId` (Long, Required): Unique identifier for the item
- `name` (String, Required): Item name
- `description` (String, Required): Item description
- `price` (Double, Required): Item price
- `quantity` (Integer, Required): Stock quantity
- `category` (String, Required): Product category

**Response:**
```json
{
  "data": {
    "createItem": {
      "itemId": 101,
      "name": "Laptop",
      "description": "Gaming Laptop",
      "price": 75000.50,
      "quantity": 5,
      "category": "Electronics"
    }
  }
}
```

### User Management Queries

#### 1. Get All Users

Retrieves all users from the system.

```graphql
query {
  users {
    userId
    username
    email
  }
}
```

**Response:**
```json
{
  "data": {
    "users": [
      {
        "userId": 1,
        "username": "john_doe",
        "email": "john.doe@example.com"
      }
    ]
  }
}
```

#### 2. Get User by ID

Retrieves a specific user by their unique identifier.

```graphql
query {
  userById(userId: 1) {
    userId
    username
    email
  }
}
```

**Parameters:**
- `userId` (Integer, Required): The user ID to retrieve

**Response:**
```json
{
  "data": {
    "userById": {
      "userId": 1,
      "username": "john_doe",
      "email": "john.doe@example.com"
    }
  }
}
```

### User Management Mutations

#### Save User

Creates a new user or updates an existing user in the system.

```graphql
mutation {
  saveUser(user: {
    userId: 1
    username: "john_doe"
    email: "john.doe@example.com"
    password: "encrypted_password"
  }) {
    userId
    username
    email
  }
}
```

**Parameters:**
- `user` (User, Required): User object containing:
  - `userId` (Integer, Required): Unique user identifier
  - `username` (String, Required): Username for login
  - `email` (String, Required): User's email address
  - `password` (String, Required): Encrypted password

**Response:**
```json
{
  "data": {
    "saveUser": {
      "userId": 1,
      "username": "john_doe",
      "email": "john.doe@example.com"
    }
  }
}
```

## 🏗️ Architecture

The application follows a **three-tier architecture pattern** with separate management domains:

### **Inventory Management Domain**

#### 1. Controller Layer - InventoryController
**File:** `InventoryController.java`
- Handles GraphQL queries and mutations for inventory items
- Maps GraphQL requests to inventory service methods
- Endpoints: `findAllItems`, `findItemByID`, `createItem`

#### 2. Service Layer - InventoryService
**File:** `InventoryService.java`
- Contains business logic for inventory operations
- Orchestrates database operations through repository
- Methods: `findItemByID()`, `findAllItems()`, `createItem()`

#### 3. Repository Layer - InventoryRepository
**File:** `InventoryRepository.java`
- Data access abstraction using Spring Data JPA
- Extends `JpaRepository<Item, Long>`
- Manages item persistence and retrieval

#### 4. Entity Layer - Item
**File:** `Item.java`
- JPA Entity mapped to database table `item`
- Represents the inventory item data model
- Uses Lombok `@Data` for automatic getters/setters

---

### **User Management Domain**

#### 1. Controller Layer - UserController
**File:** `UserController.java`
- Handles GraphQL queries and mutations for user management
- Maps GraphQL requests to user service methods
- Endpoints: `saveUser`, `users`, `userById`

#### 2. Service Layer - UserService
**File:** `UserService.java`
- Contains business logic for user account operations
- Orchestrates database operations through repository
- Methods: `saveUser()`, `users()`, `userById()`

#### 3. Repository Layer - UserRepository
**File:** `UserRepository.java`
- Data access abstraction using Spring Data JPA
- Extends `JpaRepository<User, Integer>`
- Manages user persistence and retrieval

#### 4. Entity Layer - User
**File:** `User.java`
- JPA Entity mapped to database table `user`
- Represents the user account data model
- Uses Lombok `@Data` for automatic getters/setters

---

### **Main Application Class**

**File:** `GraphQlLearningApplication.java`
- Spring Boot entry point
- Initializes both inventory and user management domains
- Enables GraphQL and database auto-configuration

## 🗄️ Database

### H2 In-Memory Database

The application uses H2 for easy development and testing:

**Configuration (application.properties):**
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.jpa.show-sql=true
spring.graphql.graphiql.enabled=true
```

**H2 Console Access:**
```
http://localhost:8080/h2-console
```

**Default Credentials:**
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (leave blank)

## 🛠️ Technologies

| Technology | Version | Purpose |
|-----------|---------|---------|
| Spring Boot | 4.0.3 | Application framework |
| Spring for GraphQL | 4.0.3 | GraphQL support |
| Spring Data JPA | 4.0.3 | Database ORM |
| H2 Database | - | In-memory database |
| Hibernate | - | JPA implementation |
| Gradle | 9.3.1 | Build tool |
| Lombok | - | Boilerplate reduction |
| Java | 17+ | Language |

## 📁 Project Structure

```
graphQL-Learning/
├── build.gradle                           # Gradle build configuration
├── settings.gradle                        # Gradle settings
├── HELP.md                                # Help documentation
├── README.md                              # This file
├── gradle/
│   └── wrapper/                           # Gradle wrapper
└── src/
    ├── main/
    │   ├── java/com/nirsb/graphql/project/graphQL_Learning/
    │   │   ├── GraphQlLearningApplication.java    # Main entry point
    │   │   ├── controller/
    │   │   │   ├── InventoryController.java       # Inventory GraphQL endpoints
    │   │   │   └── UserController.java            # User GraphQL endpoints
    │   │   ├── entity/
    │   │   │   ├── Item.java                      # Item entity
    │   │   │   └── User.java                      # User entity
    │   │   ├── repository/
    │   │   │   ├── InventoryRepository.java       # Item data access
    │   │   │   └── UserRepository.java            # User data access
    │   │   └── service/
    │   │       ├── InventoryService.java          # Item business logic
    │   │       └── UserService.java               # User business logic
    │   └── resources/
    │       ├── application.properties             # App configuration
    │       └── graphql/
    │           └── schema.graphqls                # GraphQL schema
    └── test/
        └── java/                                  # Test classes
```

## ✅ Tested GraphQL Operations

The following GraphQL operations have been verified and tested:

### Test Case 1: Create Item Mutation ✅

**Request:**
```graphql
mutation {
  createItem(
    itemId: 101
    name: "Laptop"
    description: "Gaming Laptop"
    price: 75000.50
    quantity: 5
    category: "Electronics"
  ) {
    itemId
    name
    description
    price
    quantity
    category
  }
}
```

**Status:** ✅ Verified - Successfully creates a new item in the inventory

---

### Test Case 2: Find All Items Query ✅

**Request:**
```graphql
query {
  findAllItems {
    itemId
    price
    category
  }
}
```

**Status:** ✅ Verified - Successfully retrieves all items from the database

---

### Test Case 3: Find Item By ID Query ✅

**Request:**
```graphql
query {
  findItemByID(id: 101) {
    itemId
    name
    description
    price
  }
}
```

**Status:** ✅ Verified - Successfully retrieves a specific item by its ID

---

### Test Case 4: Save User Mutation ✅

**Request:**
```graphql
mutation {
  saveUser(user: {
    userId: 1
    username: "john_doe"
    email: "john.doe@example.com"
    password: "encrypted_password"
  }) {
    userId
    username
    email
  }
}
```

**Status:** ✅ Verified - Successfully creates a new user in the system

---

### Test Case 5: Get User By ID Query ✅

**Request:**
```graphql
query {
  userById(userId: 1) {
    username
    email
  }
}
```

**Status:** ✅ Verified - Successfully retrieves a specific user by ID

---

### Test Case 6: Get All Users Query ✅

**Request:**
```graphql
query {
  users {
    userId
    username
    email
    password
  }
}
```

**Status:** ✅ Verified - Successfully retrieves all users from the system

---

## 📖 Reference Documentation

### Official Guides
- [Building a GraphQL service](https://spring.io/guides/gs/graphql-server/)
- [Spring for GraphQL Documentation](https://docs.spring.io/spring-boot/4.0.3/reference/web/spring-graphql.html)
- [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/4.0.3/reference/)

### External Resources
- [GraphQL Official Documentation](https://graphql.org/)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [H2 Database Documentation](https://h2database.com/)

## 🤝 Contributing

This is a learning project. Feel free to extend it with additional features such as:
- Update and Delete mutations
- Custom GraphQL queries with filters
- Error handling and validation
- Unit and integration tests
- Additional entity relationships

## 📝 Notes

- The original package name `com.nirsb.graphql.project.graphQL-Learning` is invalid and has been replaced with `com.nirsb.graphql.project.graphQL_Learning`
- All classes are fully documented with JavaDoc comments
- The application uses Spring Boot 4.0.3 with modern Spring GraphQL features

## 🔗 Related Files

- **HELP.md** - Extended technical documentation
- **build.gradle** - Gradle build configuration with dependencies
- **schema.graphqls** - GraphQL schema definition

---

**Version:** 0.0.1  
**Last Updated:** March 9, 2026  
**Author:** GraphQL Learning Team

