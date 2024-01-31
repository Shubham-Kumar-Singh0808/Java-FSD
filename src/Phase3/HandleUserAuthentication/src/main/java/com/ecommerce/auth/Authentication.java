package com.ecommerce.auth;

public class Authentication {

    // Simulated user credentials
    private static final String VALID_USERNAME = "Shubham";
    private static final String VALID_PASSWORD = "Shubham123";

    /**
     * Authenticate user based on username and password.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @return true if authentication is successful, false otherwise.
     */
    public boolean authenticateUser(String username, String password) {
        return isValidCredentials(username, password);
    }

    /**
     * Validate the username and password against the valid credentials.
     *
     * @param username The username entered by the user.
     * @param password The password entered by the user.
     * @return true if the username and password match the valid credentials, false otherwise.
     */
    private boolean isValidCredentials(String username, String password) {
        // Check if the provided username and password match the valid credentials
        return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
    }
}
