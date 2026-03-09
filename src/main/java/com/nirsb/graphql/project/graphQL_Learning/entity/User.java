package com.nirsb.graphql.project.graphQL_Learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * User Entity - Represents a user account in the system.
 *
 * <p>This entity is mapped to the database table and contains all properties related to a user
 * account. It serves as the data model for user authentication, profile management, and system
 * access control.</p>
 *
 * <p>Properties:</p>
 * <ul>
 *   <li><b>userId</b>: Unique identifier for the user (Primary Key)</li>
 *   <li><b>username</b>: Unique username for login authentication</li>
 *   <li><b>email</b>: User's email address for communication and recovery</li>
 *   <li><b>password</b>: Encrypted password for secure authentication</li>
 * </ul>
 *
 * <p>Example User:</p>
 * <pre>
 * userId: 1
 * username: "john_doe"
 * email: "john.doe@example.com"
 * password: "$2a$10$..." (encrypted)
 * </pre>
 *
 * <p><b>Security Note:</b> Passwords should always be encrypted using a secure hashing algorithm
 * (e.g., bcrypt) before persisting to the database.</p>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Entity
@Table(name = "app_user")
@Data
public class User {

    /** Unique identifier for the user (Primary Key) */
    @Id
    private int userId;

    /** Unique username for login authentication */
    private String username;

    /** User's email address for communication and account recovery */
    private String email;

    /** Encrypted password for secure authentication */
    private String password;
}
