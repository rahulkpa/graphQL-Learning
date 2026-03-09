package com.nirsb.graphql.project.graphQL_Learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Item Entity - Represents an inventory item in the system.
 *
 * <p>This entity is mapped to the database table and contains all properties related to an item
 * in the inventory system. It serves as the data model for both database persistence and GraphQL
 * schema representation.</p>
 *
 * <p>Properties:</p>
 * <ul>
 *   <li><b>itemId</b>: Unique identifier for the item (Primary Key)</li>
 *   <li><b>name</b>: Display name of the item</li>
 *   <li><b>description</b>: Detailed description of the item</li>
 *   <li><b>price</b>: Cost of the item in currency units</li>
 *   <li><b>quantity</b>: Available quantity in stock</li>
 *   <li><b>category</b>: Product category (e.g., Electronics, Clothing)</li>
 * </ul>
 *
 * <p>Example Item:</p>
 * <pre>
 * itemId: 101
 * name: "Laptop"
 * description: "Gaming Laptop"
 * price: 75000.50
 * quantity: 5
 * category: "Electronics"
 * </pre>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Entity
@Data
public class Item {

    /** Unique identifier for the item (Primary Key) */
    @Id
    private Long itemId;

    /** Display name of the item */
    private String name;

    /** Detailed description of the item */
    private String description;

    /** Cost of the item in currency units */
    private Double price;

    /** Available quantity in stock */
    private Integer quantity;

    /** Product category classification */
    private String category;
}
