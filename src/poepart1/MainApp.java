package poepart1;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            if (choice == 1) {
                // Register
                System.out.print("Enter first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter last name: ");
                String lastName = input.nextLine();
                System.out.print("Enter username: ");
                String username = input.nextLine();
                System.out.print("Enter password: ");
                String password = input.nextLine();
                System.out.print("Enter cell phone (+27...): ");
                String cellPhone = input.nextLine();

                Login login = new Login(username, password, cellPhone);
                User user = new User(firstName, lastName);

                if (login.checkUserName() && login.checkPasswordComplexity() && login.checkCellPhoneNumber()) {
                    System.out.println("Registration successful!");

                    // 🔹 Save details to file
                    FileHandler fileHandler = new FileHandler();
                    String data = firstName + "," + lastName + "," + username + "," + password + "," + cellPhone;
                    fileHandler.saveToFile(data);

                } else {
                    System.out.println("Registration failed. Please check your details.");
                }

            } else if (choice == 2) {
                // Login
                FileHandler fileHandler = new FileHandler();
                String data = fileHandler.readLastUser();

                if (data == null) {
                    System.out.println("No user data found. Please register first.");
                } else {
                    String[] parts = data.split(",");
                    String firstName = parts[0];
                    String lastName = parts[1];
                    String username = parts[2];
                    String password = parts[3];
                    String cellPhone = parts[4];

                    Login login = new Login(username, password, cellPhone);
                    User user = new User(firstName, lastName);

                    System.out.print("Enter username: ");
                    String enteredUsername = input.nextLine();
                    System.out.print("Enter password: ");
                    String enteredPassword = input.nextLine();

                    boolean status = login.loginUser(enteredUsername, enteredPassword);
                    System.out.println(login.returnLoginStatus(status, user.getFirstName(), user.getLastName()));
                }

            } else if (choice == 3) {
                // Exit
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}