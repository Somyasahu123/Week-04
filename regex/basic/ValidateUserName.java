package regex.basic;

import java.util.Scanner;

public class ValidateUserName {
    // Regular expression pattern for a valid username
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

    public static boolean isValidUsername(String username) {
        // Check if the username matches the pattern
        return username.matches(USERNAME_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a username to validate: ");
        String username = scanner.nextLine();

        // Checking if the username is valid
        if (isValidUsername(username)) {
            System.out.println("Valid username!");
        } else {
            System.out.println("Invalid username! It must start with a letter, be 5-15 characters long, and contain only letters, numbers, or underscores.");
        }

        scanner.close();
    }
}

