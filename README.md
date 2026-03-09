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

## 📮 Testing with Postman

### Overview

This section provides a complete guide to testing GraphQL operations using Postman. The screenshot below shows a successful Create Item mutation request.

**Screenshot Reference:**
```
┌─────────────────────────────────────────────────────────────────┐
│ Postman - GraphQL Request                                       │
├─────────────────────────────────────────────────────────────────┤
│ Method: POST | URL: http://localhost:8080/graphql               │
├─────────────────────────────────────────────────────────────────┤
│ ┌─ QUERY ──────────────────┐  ┌─ GRAPHQL VARIABLES ──────────┐ │
│ │ mutation createItem(     │  │ {                             │ │
│ │   $itemId: Int!,         │  │   "itemId": 101,              │ │
│ │   $name: String!,        │  │   "name": "Laptop",           │ │
│ │   $description: String!  │  │   "description": "Gaming...   │ │
│ │   $price: Float!,        │  │   "price": 75000.5,           │ │
│ │   $quantity: Int!,       │  │   "quantity": 5,              │ │
│ │   $category: String!     │  │   "category": "Electronics"   │ │
│ │ ) {                      │  │ }                             │ │
│ │   createItem(            │  └───────────────────────────────┘ │
│ │     itemId: $itemId      │                                     │
│ │     name: $name          │  RESPONSE: 200 OK | 105 ms         │
│ │     description: $desc   │  ┌───────────────────────────────┐ │
│ │     price: $price        │  │ {                             │ │
│ │     quantity: $quantity  │  │   "data": {                   │ │
│ │     category: $category  │  │     "createItem": {           │ │
│ │   ) {                    │  │       "itemId": 101,          │ │
│ │     itemId               │  │       "name": "Laptop",       │ │
│ │     name                 │  │       "price": 75000.5,       │ │
│ │     price                │  │       "quantity": 5,          │ │
│ │     quantity             │  │       "category": "Elec..."   │ │
│ │     category             │  │     }                         │ │
│ │   }                      │  │   }                           │ │
│ │ }                        │  │ }                             │ │
│ └──────────────────────────┘  └───────────────────────────────┘ │
└─────────────────────────────────────────────────────────────────┘
```

### Step 1: Setup Postman Request

1. **Open Postman** and create a new request
2. **Set the method to POST**
3. **Enter the URL:** `http://localhost:8080/graphql`
4. **Go to the "Body" tab** and select **GraphQL** option

### Step 2: Create Item Mutation with Variables

#### Query

```graphql
mutation createItem(
  $itemId: Int!,
  $name: String!,
  $description: String!,
  $price: Float!,
  $quantity: Int!,
  $category: String!
) {
  createItem(
    itemId: $itemId
    name: $name
    description: $description
    price: $price
    quantity: $quantity
    category: $category
  ) {
    itemId
    name
    price
    quantity
    category
  }
}
```

#### Variables

```json
{
  "itemId": 101,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000.5,
  "quantity": 5,
  "category": "Electronics"
}
```

#### Expected Response

```json
{
  "data": {
    "createItem": {
      "itemId": 101,
      "name": "Laptop",
      "price": 75000.5,
      "quantity": 5,
      "category": "Electronics"
    }
  }
}
```

**Response Details:**
- **Status Code:** `200 OK` ✅
- **Response Time:** `105 ms`
- **Response Size:** `272 B`

### Step 3: Complete Postman Setup Instructions

#### Detailed Setup Guide

1. **Download & Install Postman**
   - Visit [postman.com/downloads](https://www.postman.com/downloads/)
   - Download for your operating system (Windows, Mac, or Linux)
   - Install and launch Postman

2. **Create New Request**
   - Click the `+` icon or go to `New` → `Request`
   - Name your request: `Create Item`
   - Select a collection or create new
   - Click `Save`

3. **Configure Request Method & URL**
   - **Method Dropdown:** Select `POST` (far left)
   - **URL Field:** Enter `http://localhost:8080/graphql`
   - Press `Enter` to confirm

4. **Add Headers**
   - Click the `Headers` tab
   - Add a new header:
     - **Key:** `Content-Type`
     - **Value:** `application/json`
   - Header will be auto-applied

5. **Set Request Body - Method A (Recommended)**
   - Click the `Body` tab
   - Look for the radio button options at the bottom
   - Select `GraphQL` option
   - In the left panel (QUERY), paste the mutation query above
   - In the right panel (GRAPHQL VARIABLES), paste the variables JSON

6. **Set Request Body - Method B (Alternative)**
   - Click the `Body` tab
   - Select `raw` option
   - From the dropdown (right side), select `JSON`
   - Paste the following JSON structure:
   ```json
   {
     "query": "mutation createItem($itemId: Int!, $name: String!, $description: String!, $price: Float!, $quantity: Int!, $category: String!) { createItem(itemId: $itemId, name: $name, description: $description, price: $price, quantity: $quantity, category: $category) { itemId, name, price, quantity, category } }",
     "variables": {
       "itemId": 101,
       "name": "Laptop",
       "description": "Gaming Laptop",
       "price": 75000.5,
       "quantity": 5,
       "category": "Electronics"
     }
   }
   ```

7. **Send Request & View Response**
   - Click the blue `Send` button (right side)
   - Wait for the response (usually 100-200ms)
   - View the response in the panel below
   - Check the status code (should be `200 OK`)

### Step 4: Test Other Operations

You can test all operations using similar steps:

| Operation | Type | Query Name | Example ID |
|-----------|------|-----------|-----------|
| Create Item | Mutation | `createItem` | 101 |
| Find All Items | Query | `findAllItems` | N/A |
| Find Item By ID | Query | `findItemByID` | 101 |
| Save User | Mutation | `saveUser` | 1 |
| Get User By ID | Query | `userById` | 1 |
| Get All Users | Query | `users` | N/A |

#### Quick Test: Find All Items

**Query:**
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

**Steps:**
1. Create a new request named `Find All Items`
2. Use the same URL: `http://localhost:8080/graphql`
3. Select `Body` → `GraphQL`
4. Paste the query above (no variables needed)
5. Click `Send`

### Step 5: Postman Collections (Optional)

**Create a Postman Collection for All Operations:**

1. Click `Collections` (left sidebar)
2. Click `New Collection` → Name it `GraphQL Learning`
3. Add requests for each operation:
   - Create Item
   - Find All Items
   - Find Item By ID
   - Save User
   - Get User By ID
   - Get All Users
4. Save all URLs as `{{base_url}}/graphql`
5. Create environment variable `base_url = http://localhost:8080`

### Alternative: Using cURL

If you prefer command-line testing, use cURL:

```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "mutation createItem($itemId: Int!, $name: String!, $description: String!, $price: Float!, $quantity: Int!, $category: String!) { createItem(itemId: $itemId, name: $name, description: $description, price: $price, quantity: $quantity, category: $category) { itemId, name, price, quantity, category } }",
    "variables": {
      "itemId": 101,
      "name": "Laptop",
      "description": "Gaming Laptop",
      "price": 75000.5,
      "quantity": 5,
      "category": "Electronics"
    }
  }'
```

### Troubleshooting Postman Issues

| Issue | Solution |
|-------|----------|
| **Connection Refused** | Ensure application is running on `http://localhost:8080` |
| **400 Bad Request** | Check JSON syntax in variables and query |
| **500 Server Error** | Check application logs for errors |
| **GraphQL not showing** | Make sure `GraphQL` option is selected in Body tab |
| **Empty Response** | Verify variables match the mutation parameters |

## 🔐 Password Encryption

### Overview

This application implements **BCrypt password encryption** to securely store user passwords. BCrypt is a widely-used, industry-standard password hashing algorithm that provides strong security for user authentication.

---

## 🔑 Authentication & Security Configuration

### What Happened with the Generated Password?

When you added Spring Security, you saw:
```
Using generated security password: 62d5962b-5e21-4004-8521-c4ec580d4f87
```

This is Spring Security's default behavior. **We've now disabled this** so you can use your own custom users stored in the database.

### Current Security Configuration

The `SecurityConfig.java` file now:

✅ **Disables the auto-generated password** - No more random password on startup
✅ **Allows public GraphQL access** - No authentication required for `/graphql` endpoints
✅ **Allows H2 console access** - For development and database inspection
✅ **Disables CSRF** - Suitable for GraphQL APIs
✅ **Uses BCrypt encoding** - For secure password storage

### Security Architecture

```
Application Startup:
┌─────────────────────────────────────┐
│ Spring Boot Application Starts       │
├─────────────────────────────────────┤
│ ✅ No auto-generated password!      │
│ ✅ SecurityConfig loads             │
│ ✅ GraphQL endpoints open           │
│ ✅ All endpoints are public         │
└─────────────────────────────────────┘

Public Endpoints (No Auth Required):
├── POST /graphql          (GraphQL API)
├── GET /graphiql          (GraphQL UI)
├── GET /h2-console/**     (Database Console)
└── GET /                  (All other paths)
```

### SecurityConfig.java Breakdown

**1. Password Encoder Bean**
```java
@Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```
- Creates BCryptPasswordEncoder
- Used for encoding passwords when saving users
- Used for verifying passwords during login

**2. Security Filter Chain**
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authz -> authz
            .requestMatchers("/graphql").permitAll()
            .requestMatchers("/graphiql").permitAll()
            .requestMatchers("/h2-console/**").permitAll()
            .anyRequest().permitAll()
        )
        .csrf(csrf -> csrf.disable())
        .httpBasic(httpBasic -> httpBasic.disable())
        .formLogin(formLogin -> formLogin.disable())
        .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
    
    return http.build();
}
```

**What each part does:**

| Configuration | Purpose |
|---------------|---------|
| `.permitAll()` | Allow access without authentication |
| `.csrf().disable()` | Disable CSRF (safe for GraphQL) |
| `.httpBasic().disable()` | No HTTP Basic auth popup |
| `.formLogin().disable()` | No default login form |
| `.frameOptions().disable()` | Allow H2 console in iframe |

### How It Works Now

#### Step 1: Save User with Encrypted Password

```graphql
mutation {
  saveUser(user: {
    userId: 1
    username: "john_doe"
    email: "john.doe@example.com"
    password: "plaintext_password_123"
  }) {
    userId
    username
    email
  }
}
```

**What happens:**
1. ✅ No authentication required (endpoint is public)
2. ✅ UserService receives plain-text password
3. ✅ BCryptPasswordEncoder encrypts it
4. ✅ Encrypted password saved to database

#### Step 2: Verify Password (For Login - Future Enhancement)

```java
// In your login controller or service
User user = userService.userById(1);
String loginPassword = "plaintext_password_123";

if (userService.verifyPassword(loginPassword, user.getPassword())) {
    // ✅ Password matches - authentication successful
} else {
    // ❌ Password doesn't match - authentication failed
}
```

#### Step 3: Query User

```graphql
query {
  users {
    userId
    username
    email
    password  # This will be encrypted: $2a$10$...
  }
}
```

### Database Verification

To verify passwords are encrypted in H2 Console:

1. **Go to:** `http://localhost:8080/h2-console`
2. **Run SQL:**
   ```sql
   SELECT user_id, username, password FROM app_user;
   ```
3. **See encrypted passwords:**
   ```
   user_id | username  | password
   --------|-----------|--------------------------------------
   1       | john_doe  | $2a$10$N9qo8uLOickgx2ZMRZoMyeIj7lttP87...
   ```

### Security Features

#### ✅ What's Secure Now:

1. **Password Encryption**
   - Passwords encrypted with BCrypt
   - Cannot be reversed
   - Unique for each user

2. **Public Access**
   - GraphQL endpoints accessible
   - H2 console for development
   - No authentication blocking

3. **CSRF Protection Disabled**
   - Suitable for GraphQL
   - Stateless API operations

#### ⚠️ Production Considerations:

For production deployment, you should:

```java
// PRODUCTION: Enable CSRF
.csrf(csrf -> csrf.csrfTokenRepository(...))

// PRODUCTION: Require authentication
.authorizeHttpRequests(authz -> authz
    .requestMatchers("/graphql").authenticated()
    .requestMatchers("/login").permitAll()
    .anyRequest().authenticated()
)

// PRODUCTION: Add JWT or OAuth2
.addFilterBefore(new JwtAuthenticationFilter(), ...)

// PRODUCTION: Disable H2 console
.requestMatchers("/h2-console/**").denyAll()

// PRODUCTION: HTTPS only
.requiresChannel(channel -> channel
    .anyRequest()
    .requiresSecure()
)
```

### No More Generated Password!

**Before Configuration:**
```
Using generated security password: 62d5962b-5e21-4004-8521-c4ec580d4f87
```

**After Configuration:**
```
✅ No generated password message
✅ Application starts normally
✅ GraphQL endpoints ready to use
✅ Users stored with encrypted passwords
```

### Testing the Setup

**1. Save User (No Auth Required)**
```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "mutation { saveUser(user: {userId: 1, username: \"john\", email: \"john@test.com\", password: \"test123\"}) { userId username } }"
  }'
```

**2. Get User (No Auth Required)**
```bash
curl -X POST http://localhost:8080/graphql \
  -H "Content-Type: application/json" \
  -d '{
    "query": "query { userById(userId: 1) { userId username email } }"
  }'
```

**3. Check H2 Console**
```
URL: http://localhost:8080/h2-console
Password field shows encrypted hash (✅ Success!)
```

### Configuration Files

```
config/
├── SecurityConfig.java         # Password encoder & security rules
└── (Other configs as needed)
```

---

### Why BCrypt?

BCrypt is preferred over plain-text password storage because:

1. **Non-reversible:** Passwords cannot be decrypted (one-way hashing)
2. **Salted:** Automatically includes a unique salt to prevent rainbow table attacks
3. **Adaptive:** Computational cost increases over time as computers get faster
4. **Spring Integrated:** Works seamlessly with Spring Security framework

### How Password Encryption Works

```
User Registration Flow:
┌─────────────────────────────────────────────────────┐
│ 1. User enters password: "myPassword123"             │
├─────────────────────────────────────────────────────┤
│ 2. GraphQL mutation sends plain-text password       │
│    saveUser(user: {                                 │
│      userId: 1                                      │
│      username: "john_doe"                           │
│      password: "myPassword123"                      │
│    })                                               │
├─────────────────────────────────────────────────────┤
│ 3. UserService receives user object                 │
├─────────────────────────────────────────────────────┤
│ 4. BCryptPasswordEncoder encrypts password:         │
│    $2a$10$N9qo8uLOickgx2ZMRZoMyeIj...              │
├─────────────────────────────────────────────────────┤
│ 5. Encrypted password stored in database            │
├─────────────────────────────────────────────────────┤
│ 6. Original password is NEVER stored                │
└─────────────────────────────────────────────────────┘
```

### BCrypt Hash Format

A BCrypt-encoded password looks like this:

```
$2a$10$N9qo8uLOickgx2ZMRZoMyeIj7lttP87leuQmyJ55ZWlqaklVWzwK2
└──┘└┘└──────────────────────────────────────────────────────┘
 │  │  Hashed password (22 characters) + salt
 │  Rounds (2^10 = 1024 iterations)
 Algorithm version (2a = BCrypt)
```

### Implementation Details

#### SecurityConfig.java
Creates a BCryptPasswordEncoder bean for use throughout the application:

```java
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

#### UserService.java - saveUser() Method
Automatically encrypts the password before saving:

```java
public User saveUser(User user) {
    // Encrypt the password before saving
    String encryptedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encryptedPassword);
    return userRepository.save(user);
}
```

### Password Verification

To verify a user's password during login (future enhancement):

```java
public boolean verifyPassword(String rawPassword, String encodedPassword) {
    return passwordEncoder.matches(rawPassword, encodedPassword);
}
```

**Usage Example:**
```java
User user = userService.userById(1);
String loginPassword = "myPassword123";

if (userService.verifyPassword(loginPassword, user.getPassword())) {
    // Authentication successful - passwords match
    System.out.println("Login successful!");
} else {
    // Authentication failed - passwords don't match
    System.out.println("Invalid credentials");
}
```

### Testing Password Encryption in Postman

#### Mutation Request

```graphql
mutation {
  saveUser(user: {
    userId: 1
    username: "john_doe"
    email: "john.doe@example.com"
    password: "plaintext_password_123"
  }) {
    userId
    username
    email
  }
}
```

#### Expected Response

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

**Important:** Notice the response does NOT include the password. The password is encrypted and stored safely in the database.

#### Verification in H2 Console

1. Go to **H2 Console:** `http://localhost:8080/h2-console`
2. Run SQL query:
   ```sql
   SELECT * FROM app_user WHERE user_id = 1;
   ```
3. You'll see the password stored as:
   ```
   $2a$10$N9qo8uLOickgx2ZMRZoMyeIj7lttP87leuQmyJ55ZWlqaklVWzwK2
   ```
   (Not the plain text "plaintext_password_123")

### Query Encrypted Passwords

When retrieving users, passwords are returned as encrypted hashes:

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

Response:
```json
{
  "data": {
    "users": [
      {
        "userId": 1,
        "username": "john_doe",
        "email": "john.doe@example.com",
        "password": "$2a$10$N9qo8uLOickgx2ZMRZoMyeIj7lttP87leuQmyJ55ZWlqaklVWzwK2"
      }
    ]
  }
}
```

### Security Best Practices

✅ **DO:**
- ✅ Always encrypt passwords before storing
- ✅ Use strong hashing algorithms like BCrypt
- ✅ Never log or display plain-text passwords
- ✅ Use HTTPS for all password transmissions
- ✅ Implement rate limiting on login attempts
- ✅ Add password strength validation

❌ **DON'T:**
- ❌ Store plain-text passwords
- ❌ Use weak hashing like MD5 or SHA1
- ❌ Try to decrypt passwords (they can't be!)
- ❌ Send passwords via unsecured HTTP
- ❌ Display passwords in API responses
- ❌ Accept weak passwords (< 8 characters)

### Future Enhancements

To further improve security, consider adding:

1. **Password Strength Validation**
   - Minimum length requirements
   - Special character requirements
   - Number and uppercase letter requirements

2. **Login Authentication**
   - Verify password during login using `passwordEncoder.matches()`
   - Return JWT token for authenticated requests

3. **Password Change/Reset**
   - Allow users to change passwords
   - Implement password reset via email

4. **Account Lockout**
   - Lock accounts after multiple failed login attempts
   - Implement rate limiting

5. **HTTPS Enforcement**
   - Ensure all requests use HTTPS
   - Prevent password transmission over HTTP

### Dependencies

Password encryption requires Spring Security:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-security'
```

This is automatically added to your `build.gradle` file.

### References

- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [BCrypt Algorithm](https://en.wikipedia.org/wiki/Bcrypt)
- [OWASP Password Storage Cheat Sheet](https://cheatsheetseries.owasp.org/cheatsheets/Password_Storage_Cheat_Sheet.html)



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

