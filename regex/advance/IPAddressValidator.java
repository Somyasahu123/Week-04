package regex.advance;

import java.util.Scanner;
import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter an IPv4 address:");
        String ipAddress = scanner.nextLine();

        // Regular expression pattern for a valid IPv4 address
        String ipPattern = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

        // Compiling the pattern
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ipAddress);

        // Checking if the entered IP is valid
        if (matcher.matches()) {
            System.out.println("Valid IPv4 address.");
        } else {
            System.out.println("Invalid IPv4 address.");
        }

        scanner.close();
    }
}


