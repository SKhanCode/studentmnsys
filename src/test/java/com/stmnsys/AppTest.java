package com.stmnsys;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 * Unit test for App.
 */
class AppTest {

    /**
     * Verifies that the application's main method runs without throwing an exception.
     */
    @Test
    void mainRunsWithoutException() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}
