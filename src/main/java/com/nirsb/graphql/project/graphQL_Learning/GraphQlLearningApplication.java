package com.nirsb.graphql.project.graphQL_Learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * GraphQL Learning Application - Main entry point for the Spring Boot GraphQL application.
 *
 * <p>This application demonstrates a GraphQL server implementation with Spring Boot,
 * utilizing Spring for GraphQL and Spring Data JPA for database operations.</p>
 *
 * <p>Key Features:</p>
 * <ul>
 *   <li>GraphQL queries for retrieving items by ID and listing all items</li>
 *   <li>GraphQL mutations for creating new items in the inventory</li>
 *   <li>H2 in-memory database for data persistence</li>
 *   <li>GraphiQL interface enabled for interactive GraphQL exploration</li>
 *   <li>REST support through Spring Web</li>
 * </ul>
 *
 * <p>The application uses a three-tier architecture with controller, service, and repository layers.</p>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@SpringBootApplication
public class GraphQlLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQlLearningApplication.class, args);
	}

}
