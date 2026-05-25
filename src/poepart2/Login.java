/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Handles user login and validation.
 */
package poepart2;

public class Login {
    private String username;
    private String password;
    private String phoneNumber;

    public Login(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // ✅ Username must contain underscore and be at least 4 characters
    public boolean checkUserName() {
        return username.contains("_") && username.length() >= 4;
    }

    // ✅ Password must meet complexity requirements
    public boolean checkPasswordComplexity() {
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial && password.length() >= 8;
    }

    public String loginStatus() {
        if (checkUserName() && checkPasswordComplexity()) {
            return "Login successful!";
        } else {
            return "Login failed. Please check your username or password.";
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
