package com.nirsb.graphql.project.graphQL_Learning.service;

import com.nirsb.graphql.project.graphQL_Learning.entity.User;
import com.nirsb.graphql.project.graphQL_Learning.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService - Business logic layer for user management operations.
 *
 * <p>This service class provides business logic for managing user accounts including
 * creating, retrieving, and querying user data. It acts as an intermediary between the
 * controller and repository layers, encapsulating business operations for user management.</p>
 *
 * <p>The service is marked as a Spring {@code @Service} component and utilizes constructor injection
 * for dependency management through Lombok's {@code @AllArgsConstructor} annotation.</p>
 *
 * <p>Security Features:</p>
 * <ul>
 *   <li>Passwords are automatically encrypted using BCrypt before being persisted</li>
 *   <li>Each password hash is unique due to automatic salt generation</li>
 *   <li>Passwords cannot be decrypted (one-way hashing)</li>
 * </ul>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Saves a new user or updates an existing user in the system.
     *
     * <p>This method persists the provided user object to the database repository.
     * The password is automatically encrypted using BCrypt before being saved.
     * If the user has an existing userId, the record will be updated; otherwise,
     * a new user record will be created.</p>
     *
     * <p>Security Implementation:</p>
     * <ul>
     *   <li>Raw password is encrypted using {@link org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder}</li>
     *   <li>Encrypted password is stored in the database</li>
     *   <li>Original password is never stored</li>
     * </ul>
     *
     * @param user the user object to be saved or updated
     * @return the saved user with encrypted password persisted
     *
     * @example
     * <pre>
     * User newUser = new User();
     * newUser.setUserId(1);
     * newUser.setUsername("john_doe");
     * newUser.setEmail("john@example.com");
     * newUser.setPassword("plaintext_password");
     *
     * User savedUser = userService.saveUser(newUser);
     * // Password is now encrypted in database as: $2a$10$...
     * </pre>
     */
    public User saveUser(User user) {
        // Encrypt the password before saving
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    /**
     * Retrieves all users from the system.
     *
     * <p>This method fetches all available users from the database repository.</p>
     *
     * @return a list of all users in the system; returns an empty list if no users exist
     */
    public List<User> users() {
        return userRepository.findAll();
    }

    /**
     * Finds a specific user by their unique identifier.
     *
     * <p>This method queries the repository for a user with the given ID.
     * If the user exists, it is returned; otherwise, null is returned.</p>
     *
     * @param userId the unique identifier of the user to find
     * @return the user with the specified ID, or null if not found
     */
    public User userById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * Verifies if a provided password matches the encrypted password stored for a user.
     *
     * <p>This method is useful for authentication purposes. It uses BCrypt's comparison
     * method to safely compare a plain-text password with its encrypted counterpart
     * without ever decrypting the stored password.</p>
     *
     * @param rawPassword the plain-text password to verify
     * @param encodedPassword the encrypted password stored in the database
     * @return true if the passwords match, false otherwise
     *
     * @example
     * <pre>
     * User user = userService.userById(1);
     * String loginPassword = "user_entered_password";
     *
     * if (userService.verifyPassword(loginPassword, user.getPassword())) {
     *     // Authentication successful
     * } else {
     *     // Authentication failed
     * }
     * </pre>
     */
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

