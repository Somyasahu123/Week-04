package regex.basic;

import java.util.Scanner;

public class ValidateLicenseNumber {
    // Regular expression pattern for a valid license plate
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";

    public static boolean isValidLicensePlate(String plate) {
        // Check if the license plate matches the pattern
        return plate.matches(LICENSE_PLATE_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a license plate to validate: ");
        String plate = scanner.nextLine();

        // Checking if the license plate is valid
        if (isValidLicensePlate(plate)) {
            System.out.println("Valid license plate!");
        } else {
            System.out.println("Invalid license plate! It must start with two uppercase letters followed by four digits.");
        }

        scanner.close();
    }
}


