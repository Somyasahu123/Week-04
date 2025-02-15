package regex.basic;

import java.util.Scanner;

public class ValidateHexColorCode {
    // Regular expression pattern for a valid hex color code
    private static final String HEX_COLOR_PATTERN = "^#[0-9A-Fa-f]{6}$";

    public static boolean isValidHexColor(String color) {
        // Check if the color matches the pattern
        return color.matches(HEX_COLOR_PATTERN);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.print("Enter a hex color code to validate: ");
        String color = scanner.nextLine();

        // Checking if the hex color code is valid
        if (isValidHexColor(color)) {
            System.out.println("Valid hex color code!");
        } else {
            System.out.println("Invalid hex color! It must start with # followed by exactly 6 hexadecimal characters.");
        }

        scanner.close();
    }
}

