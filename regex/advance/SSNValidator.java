package regex.advance;

import java.util.Scanner;
import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user
        System.out.println("Enter a Social Security Number (SSN):");
        String input = scanner.nextLine();

        // Regular expression pattern for SSN (format: XXX-XX-XXXX)
        String ssnPattern = "\\b\\d{3}-\\d{2}-\\d{4}\\b";

        // Compiling the pattern
        Pattern pattern = Pattern.compile(ssnPattern);
        Matcher matcher = pattern.matcher(input);

        // Checking if the input contains a valid SSN
        if (matcher.find()) {
            System.out.println("\"" + matcher.group() + "\" is valid.");
        } else {
            System.out.println(" \"" + input + "\" is invalid.");
        }

        scanner.close();
    }
}


