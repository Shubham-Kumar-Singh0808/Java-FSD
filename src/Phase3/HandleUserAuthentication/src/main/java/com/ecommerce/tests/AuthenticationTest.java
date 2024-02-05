package com.ecommerce.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.ecommerce.auth.Authentication;

public class AuthenticationTest {

    @Test
    void testAuthenticationSuccess() {
        Authentication auth = new Authentication();
        assertTrue(auth.authenticateUser("Kritika", "KritikaTiwari"));
    }
}
