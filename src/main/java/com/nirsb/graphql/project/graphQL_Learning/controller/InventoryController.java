package com.nirsb.graphql.project.graphQL_Learning.controller;

import com.nirsb.graphql.project.graphQL_Learning.entity.Item;
import com.nirsb.graphql.project.graphQL_Learning.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * InventoryController - Handles GraphQL queries and mutations for inventory management.
 *
 * <p>This controller exposes GraphQL endpoints for:
 * <ul>
 *   <li>Querying all items in the inventory</li>
 *   <li>Querying items by their unique ID</li>
 *   <li>Creating new items via mutations</li>
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
public class InventoryController {

    private final InventoryService inventoryService;

    /**
     * Retrieves all items from the inventory.
     *
     * <p>GraphQL Query Example:</p>
     * <pre>
     * query {
     *   findAllItems {
     *     itemId
     *     name
     *     price
     *     category
     *   }
     * }
     * </pre>
     *
     * @return a list of all available items in the inventory
     */
    @QueryMapping
    public List<Item> findAllItems() {
        return inventoryService.findAllItems();
    }

    /**
     * Retrieves a specific item by its unique identifier.
     *
     * <p>GraphQL Query Example:</p>
     * <pre>
     * query {
     *   findItemByID(id: 101) {
     *     itemId
     *     name
     *     description
     *     price
     *   }
     * }
     * </pre>
     *
     * @param id the unique identifier of the item to retrieve
     * @return the item with the specified ID, or null if not found
     */
    @QueryMapping
    private Item findItemByID(@Argument Long id) {
        return inventoryService.findItemByID(id);
    }


    /**
     * Creates a new item in the inventory.
     *
     * <p>This is a GraphQL mutation that accepts all item properties and persists them to the database.</p>
     *
     * <p>GraphQL Mutation Example:</p>
     * <pre>
     * mutation {
     *   createItem(
     *     itemId: 101
     *     name: "Laptop"
     *     description: "Gaming Laptop"
     *     price: 75000.50
     *     quantity: 5
     *     category: "Electronics"
     *   ) {
     *     itemId
     *     name
     *     description
     *     price
     *     quantity
     *     category
     *   }
     * }
     * </pre>
     *
     * @param itemId the unique identifier for the new item
     * @param name the name of the item
     * @param description a detailed description of the item
     * @param price the price of the item
     * @param quantity the quantity in stock
     * @param category the category of the item
     * @return the created item with all properties
     */
    @MutationMapping
    public Item createItem(@Argument Long itemId,
    @Argument String name,
    @Argument String description,
    @Argument Double price,
    @Argument Integer quantity,
    @Argument String category) {
        Item item = new Item();
        item.setItemId(itemId);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setCategory(category);
        return inventoryService.createItem(item);
    }
}
