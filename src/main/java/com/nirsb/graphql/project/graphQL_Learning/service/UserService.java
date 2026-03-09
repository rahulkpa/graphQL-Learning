package com.nirsb.graphql.project.graphQL_Learning.service;

import com.nirsb.graphql.project.graphQL_Learning.entity.User;
import com.nirsb.graphql.project.graphQL_Learning.repository.UserRepository;
import lombok.AllArgsConstructor;
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
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /**
     * Saves a new user or updates an existing user in the system.
     *
     * <p>This method persists the provided user object to the database repository.
     * If the user has an existing userId, the record will be updated; otherwise,
     * a new user record will be created.</p>
     *
     * @param user the user object to be saved or updated
     * @return the saved user with all properties persisted
     */
    public User saveUser(User user) {
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
}
