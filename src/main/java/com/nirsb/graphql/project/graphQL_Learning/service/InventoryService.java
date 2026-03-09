package com.nirsb.graphql.project.graphQL_Learning.service;

import com.nirsb.graphql.project.graphQL_Learning.entity.Item;
import com.nirsb.graphql.project.graphQL_Learning.repository.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * InventoryService - Business logic layer for inventory management operations.
 *
 * <p>This service class provides business logic for managing inventory items including
 * retrieving, creating, and querying item data. It acts as an intermediary between the
 * controller and repository layers, encapsulating business operations.</p>
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
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    /**
     * Finds a specific item by its unique identifier.
     *
     * <p>This method queries the repository for an item with the given ID.
     * If the item exists, it is returned; otherwise, null is returned.</p>
     *
     * @param id the unique identifier of the item to find
     * @return the item with the specified ID, or null if not found
     */
    public Item findItemByID(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves all items from the inventory.
     *
     * <p>This method fetches all available items from the database repository.</p>
     *
     * @return a list of all items in the inventory; returns an empty list if no items exist
     */
    public List<Item> findAllItems() {
        return inventoryRepository.findAll();
    }

    /**
     * Creates and saves a new item to the inventory.
     *
     * <p>This method persists the provided item object to the database repository.
     * The item must have a unique itemId; attempting to save an item with an existing
     * ID will update the existing record.</p>
     *
     * @param item the item object to be saved to the inventory
     * @return the saved item, including any generated or updated properties
     */
    public Item createItem(Item item) {
        return inventoryRepository.save(item);
    }
}
