package com.nirsb.graphql.project.graphQL_Learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security Configuration - Provides beans and configuration for security operations.
 *
 * <p>This configuration class creates Spring Security beans for password encoding and configures
 * the security filter chain for the application. It disables the default Spring Security password
 * and allows GraphQL endpoints to be accessed without authentication.</p>
 *
 * <p>Features:</p>
 * <ul>
 *   <li><b>BCrypt Password Encoder:</b> For secure password hashing</li>
 *   <li><b>Disabled Default Security:</b> No auto-generated password on startup</li>
 *   <li><b>Public GraphQL Access:</b> GraphQL endpoints are accessible without authentication</li>
 *   <li><b>Public H2 Console:</b> H2 database console accessible for development</li>
 *   <li><b>CSRF Disabled:</b> Disabled for development (should be enabled in production)</li>
 * </ul>
 *
 * <p>Security Configuration:</p>
 * <pre>
 * Public Endpoints (No Authentication Required):
 * - /graphql (GraphQL endpoint)
 * - /graphiql (GraphQL UI)
 * - /h2-console (H2 Database Console)
 * </pre>
 *
 * @author GraphQL Learning Team
 * @version 0.0.1
 * @since 2026-03-09
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Creates a BCryptPasswordEncoder bean for password encoding.
     *
     * <p>BCrypt is configured with default strength level. The encoder automatically
     * generates a salt for each password, making the same password hash differently
     * each time it's encoded.</p>
     *
     * <p>The BCrypt algorithm uses the following format:</p>
     * <pre>
     * $2a$10$abcdefghijklmnopqrstuvwxyz...
     * └─┘└┘└──────────────────────────┘
     *  │  │  Salt and hashed password
     *  │  Rounds (2^10)
     *  Algorithm identifier (2a = BCrypt)
     * </pre>
     *
     * @return PasswordEncoder - A BCryptPasswordEncoder instance for use throughout the application
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures the security filter chain for the application.
     *
     * <p>This configuration:</p>
     * <ul>
     *   <li>Allows public access to GraphQL endpoints (/graphql, /graphiql)</li>
     *   <li>Allows public access to H2 console for development</li>
     *   <li>Disables CSRF protection (suitable for GraphQL and development)</li>
     *   <li>Disables the default Spring Security login form</li>
     *   <li>Disables HTTP Basic authentication</li>
     * </ul>
     *
     * <p>This means:</p>
     * <ul>
     *   <li>✅ NO auto-generated password on startup</li>
     *   <li>✅ GraphQL endpoints are accessible without authentication</li>
     *   <li>✅ Users can be saved with encrypted passwords</li>
     *   <li>✅ H2 console available for database inspection</li>
     * </ul>
     *
     * <p>For Production Use:</p>
     * <ul>
     *   <li>Enable CSRF protection (remove .csrf().disable())</li>
     *   <li>Implement proper authentication (JWT, OAuth2, etc.)</li>
     *   <li>Restrict H2 console access</li>
     *   <li>Use HTTPS only</li>
     * </ul>
     *
     * @param http the HttpSecurity object to configure
     * @return SecurityFilterChain configured for the application
     * @throws Exception if configuration fails
     *
     * @example
     * <pre>
     * // How to use in the application:
     *
     * // 1. Save user with encrypted password (no authentication needed)
     * mutation {
     *   saveUser(user: {
     *     userId: 1
     *     username: "john_doe"
     *     password: "plaintext_password"
     *   }) {
     *     userId
     *     username
     *   }
     * }
     *
     * // 2. Retrieve user (no authentication needed)
     * query {
     *   userById(userId: 1) {
     *     userId
     *     username
     *     email
     *   }
     * }
     *
     * // 3. Verify password programmatically
     * userService.verifyPassword("plaintext_password", user.getPassword())
     * </pre>
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // Allow all GraphQL requests without authentication
                        .requestMatchers("/graphql").permitAll()
                        .requestMatchers("/graphiql").permitAll()
                        .requestMatchers("/graphiql/**").permitAll()
                        // Allow H2 console access (for development only)
                        .requestMatchers("/h2-console/**").permitAll()
                        // Allow access to any other endpoint
                        .anyRequest().permitAll()
                )
                // Disable CSRF protection (suitable for GraphQL APIs)
                .csrf(csrf -> csrf.disable())
                // Disable HTTP Basic authentication
                .httpBasic(httpBasic -> httpBasic.disable())
                // Disable default form login
                .formLogin(formLogin -> formLogin.disable())
                // Allow frames for H2 console
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }
}


