package com.nirsb.graphql.project.graphQL_Learning.repository;

import com.nirsb.graphql.project.graphQL_Learning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository - Data access layer for User entity operations.
 *
 * <p>This repository interface extends {@code JpaRepository} to provide CRUD (Create, Read, Update, Delete)
 * operations for User entities. It leverages Spring Data JPA to automatically generate database queries
 * based on method names and conventions.</p>
 *
 * <p>Inherited Methods:</p>
 * <ul>
 *   <li>{@code findById(Integer userId)}: Retrieves a user by their ID</li>
 *   <li>{@code findAll()}: Retrieves all users from the database</li>
 *   <li>{@code save(User user)}: Saves or updates a user</li>
 *   <li>{@code delete(User user)}: Deletes a user</li>
 *   <li>{@code deleteById(Integer userId)}: Deletes a user by ID</li>
 * </ul>
 *
 * <p>The repository is marked as a Spring {@code @Repository} component, making it eligible for
 * component scanning and dependency injection.</p>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
