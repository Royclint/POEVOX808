/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Unit tests for the Login class (simplified username rule and +27 phone format).
 */
package poepart2;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginIT {

    @Test
    public void testValidUserName() {
        Login login = new Login("Toy_The", "Passw0rd@", "+27614767216");
        assertTrue("Username should contain underscore and be at least 4 characters", login.checkUserName());
    }

    @Test
    public void testInvalidUserName() {
        Login login = new Login("Toy", "Passw0rd@", "+27614767216");
        assertFalse("Username without underscore should fail", login.checkUserName());
    }

    @Test
    public void testValidPasswordComplexity() {
        Login login = new Login("Toy_The", "Passw0rd@", "+27614767216");
        assertTrue("Password should meet complexity requirements", login.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPasswordComplexity() {
        Login login = new Login("Toy_The", "password", "+27614767216");
        assertFalse("Password without uppercase, digit, or special char should fail", login.checkPasswordComplexity());
    }

    @Test
    public void testLoginStatusSuccess() {
        Login login = new Login("Toy_The", "Passw0rd@", "+27614767216");
        assertEquals("Login successful!", login.loginStatus());
    }

    @Test
    public void testLoginStatusFailure() {
        Login login = new Login("Toy", "password", "+27614767216");
        assertEquals("Login failed. Please check your username or password.", login.loginStatus());
    }
}
