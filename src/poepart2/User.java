/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Handles user registration and stores user details.
 */
package poepart2;

import java.util.Scanner;

public class User {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phoneNumber;
    private FileHandler fh = new FileHandler();

    public void registerUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- USER REGISTRATION ---");
        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your surname: ");
        surname = sc.nextLine();

        System.out.print("Enter username (must contain underscore, e.g. Toy_The): ");
        username = sc.nextLine();

        System.out.print("Enter password (must be at least 8 characters, include uppercase, lowercase, digit, and special character): ");
        password = sc.nextLine();

        System.out.print("Enter phone number (use format +27...): ");
        phoneNumber = sc.nextLine();

        Login login = new Login(username, password, phoneNumber);

        if (login.checkUserName() && login.checkPasswordComplexity()) {
            fh.saveUser(name + "," + surname + "," + username + "," + password + "," + phoneNumber);
            System.out.println("Registration successful!");
        } else {
            System.out.println("Invalid username or password format. Please try again.");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
