/**
 * Author: Akani Sithole
 * Student Number: ST10503321
 * Module: PROG5121
 * POE Part 2 – VOX808
 * Description: Combines Part 1 registration/login validation with Part 2 messaging system.
 */
package poepart2;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileHandler fh = new FileHandler();
        User user = new User();

        System.out.println("WELCOME TO VOX808 – PROG5121 POE PART 2");

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                // ✅ Registration (Part 1 logic)
                user.registerUser();

            } else if (choice == 2) {
                // ✅ Login (Part 1 logic)
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                System.out.print("Enter phone number (use format +27...): ");
                String phoneNumber = sc.nextLine();

                Login login = new Login(username, password, phoneNumber);

                if (login.checkUserName() && login.checkPasswordComplexity()) {
                    System.out.println(login.loginStatus());

                    // ✅ Messaging menu (Part 2 logic)
                    while (true) {
                        System.out.println("\nVOX808 MENU");
                        System.out.println("1. Send Message");
                        System.out.println("2. Show Recently Sent Messages");
                        System.out.println("3. Logout");
                        System.out.print("Choose an option: ");
                        int subChoice = sc.nextInt();
                        sc.nextLine();

                        if (subChoice == 1) {
                            // ✅ Allow user to send multiple messages
                            System.out.print("How many messages would you like to send? ");
                            int messageCount = sc.nextInt();
                            sc.nextLine();

                            for (int i = 1; i <= messageCount; i++) {
                                System.out.println("\nMessage " + i + " of " + messageCount);
                                System.out.print("Enter recipient phone number (use format +27...): ");
                                String recipientPhone = sc.nextLine();
                                System.out.print("Enter message content: ");
                                String content = sc.nextLine();

                                Message msg = new Message(phoneNumber, recipientPhone, content);
                                fh.saveMessage(msg);
                            }

                            System.out.println("\nAll messages sent successfully!");

                        } else if (subChoice == 2) {
                            fh.showMessages();

                        } else if (subChoice == 3) {
                            System.out.println("Logged out successfully.");
                            break;
                        } else {
                            System.out.println("Invalid choice. Try again.");
                        }
                    }
                } else {
                    System.out.println("Login failed. Please register first or check your credentials.");
                }

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
