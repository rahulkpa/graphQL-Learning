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

## 🏗️ Architecture

The application follows a **three-tier architecture pattern**:

### 1. Controller Layer
**File:** `InventoryController.java`
- Handles GraphQL queries and mutations
- Maps GraphQL requests to service methods
- Endpoints: `findAllItems`, `findItemByID`, `createItem`

### 2. Service Layer
**File:** `InventoryService.java`
- Contains business logic for inventory operations
- Orchestrates database operations
- Methods: `findItemByID()`, `findAllItems()`, `createItem()`

### 3. Repository Layer
**File:** `InventoryRepository.java`
- Data access abstraction using Spring Data JPA
- Extends `JpaRepository<Item, Long>`
- Manages database persistence

### 4. Entity Layer
**File:** `Item.java`
- JPA Entity mapped to database table
- Represents the inventory item data model
- Uses Lombok `@Data` for automatic getters/setters

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
    │   │   │   └── InventoryController.java       # GraphQL endpoints
    │   │   ├── entity/
    │   │   │   └── Item.java                      # Item entity
    │   │   ├── repository/
    │   │   │   └── InventoryRepository.java       # Data access
    │   │   └── service/
    │   │       └── InventoryService.java          # Business logic
    │   └── resources/
    │       ├── application.properties             # App configuration
    │       └── graphql/
    │           └── schema.graphqls                # GraphQL schema
    └── test/
        └── java/                                  # Test classes
```

## ✅ Tested Operations

The following GraphQL operations have been verified:

### Test Case 1: Create Item Mutation ✅
Creates a new item in the inventory successfully.

### Test Case 2: Find All Items Query ✅
Retrieves all items from the database successfully.

### Test Case 3: Find Item By ID Query ✅
Retrieves a specific item by its ID successfully.

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

