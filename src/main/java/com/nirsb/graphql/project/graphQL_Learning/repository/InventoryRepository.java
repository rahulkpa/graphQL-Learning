package com.nirsb.graphql.project.graphQL_Learning.repository;

import com.nirsb.graphql.project.graphQL_Learning.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * InventoryRepository - Data access layer for Item entity operations.
 *
 * <p>This repository interface extends {@code JpaRepository} to provide CRUD (Create, Read, Update, Delete)
 * operations for Item entities. It leverages Spring Data JPA to automatically generate database queries
 * based on method names and conventions.</p>
 *
 * <p>Inherited Methods:</p>
 * <ul>
 *   <li>{@code findById(Long id)}: Retrieves an item by its ID</li>
 *   <li>{@code findAll()}: Retrieves all items from the database</li>
 *   <li>{@code save(Item item)}: Saves or updates an item</li>
 *   <li>{@code delete(Item item)}: Deletes an item</li>
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
public interface InventoryRepository extends JpaRepository<Item, Long> {
}
