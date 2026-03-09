package com.nirsb.graphql.project.graphQL_Learning.controller;

import com.nirsb.graphql.project.graphQL_Learning.entity.User;
import com.nirsb.graphql.project.graphQL_Learning.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * UserController - Handles GraphQL queries and mutations for user management.
 *
 * <p>This controller exposes GraphQL endpoints for:
 * <ul>
 *   <li>Querying all users in the system</li>
 *   <li>Querying users by their unique ID</li>
 *   <li>Creating/saving new users via mutations</li>
 * </ul>
 * </p>
 *
 * <p>All endpoints are GraphQL-based and can be accessed through the GraphiQL interface
 * at http://localhost:8080/graphiql</p>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Retrieves all users from the system.
     *
     * <p>GraphQL Query Example:</p>
     * <pre>
     * query {
     *   users {
     *     userId
     *     username
     *     email
     *   }
     * }
     * </pre>
     *
     * @return a list of all users in the system
     */
    @QueryMapping
    public List<User> users() {
        return userService.users();
    }

    /**
     * Retrieves a specific user by their unique identifier.
     *
     * <p>GraphQL Query Example:</p>
     * <pre>
     * query {
     *   userById(userId: 1) {
     *     userId
     *     username
     *     email
     *   }
     * }
     * </pre>
     *
     * @param userId the unique identifier of the user to retrieve
     * @return the user with the specified ID, or null if not found
     */
    @QueryMapping
    public User userById(@Argument int userId) {
        return userService.userById(userId);
    }

    /**
     * Saves a new user to the system or updates an existing user.
     *
     * <p>This is a GraphQL mutation that accepts a complete user object and persists it to the database.</p>
     *
     * <p>GraphQL Mutation Example:</p>
     * <pre>
     * mutation {
     *   saveUser(user: {
     *     userId: 1
     *     username: "john_doe"
     *     email: "john.doe@example.com"
     *     password: "encrypted_password"
     *   }) {
     *     userId
     *     username
     *     email
     *   }
     * }
     * </pre>
     *
     * @param user the user object to be saved or updated
     * @return the saved user with all properties
     */
    @MutationMapping
    public User saveUser(@Argument User user) {
        return userService.saveUser(user);
    }
}
